(function() {

  'use strict';

  angular
    .module( 'blackjack' )
    .controller( 'RoomController', RoomController );

  RoomController.$inject = [
    'RoomService',
    'DealerService',
    '$state',
    'toastr',
    '$scope'
  ];

  function RoomController( RoomService, DealerService, $state, toastr, $scope ) {

    var vm = this;

    ///////////// Properties
    vm.totalPlayers   = RoomService.numberOfPlayers;
    vm.playersData    = [];
    vm.dealerData     = DealerService.dealerData;
    vm.currentGambler = {};
    vm.currentPlayer  = {};
    vm.readyToGo      = DealerService.readyToGo;
    vm.deck           = [];

    ///////////// Public Methods
    vm.quit           = quit;
    vm.setWager       = setWager;
    vm.playerAction   = playerAction;

    ///////////// Private Methods
    var _init         = _init;

    ///////////// Methods Declaration
    function _init() {

      vm.deck = DealerService.createDeck();

      var players = [];

      if ( RoomService.playersData.length === 0 ) {
        players         = RoomService.createPlayers( RoomService.numberOfPlayers );
        vm.playersData  = DealerService.distributeCards( players );
      } else {
        players         = RoomService.playersData;
        vm.playersData  = DealerService.distributeCards( players );
      }

      vm.dealerData = { hand : [], score : 0, stand : false };

      while ( vm.dealerData.score < 17 ) {
        playerAction( vm.dealerData, 'hit' );
      }

      DealerService.dealerData = vm.dealerData;      
      vm.currentGambler        = vm.playersData[ DealerService.currentGambler ];

    }

    function quit() {

      RoomService.numberOfPlayers  = 1;
      RoomService.playersData      = [];
      DealerService.currentGambler = 0;
      vm.currentGambler            = {};
      vm.currentPlayer             = {};
      vm.readyToGo                 = false;
      vm.wager                     = '';

      $state
        .go( 'home' );
    }

    function setWager( id, wager ) {
      
      var player = vm.playersData[ id - 1 ];

      if ( player.money <= 0 ) {

        player.money = 1000;
        toastr
          .info( player.name + ' received $1000 in credit', 'Dealer says:' );

      }

      if ( !wager ) {
        toastr
          .warning( 'Choose your wager!', 'Dealer says:' );
      } else if ( player.money - wager < 0 ) {
        toastr
          .warning( 'You do not have enough money!', 'Dealer says:' );
      } else if ( Number( wager, 10 ) !== Number( wager, 10 ) ) {
        toastr
          .info( 'Only numbers are allowed!', 'Dealer says:' );
      } else {
        
        player.wager                 = wager;
        player.money                 -= wager;
        vm.playersData[ id - 1 ]     = player;
        DealerService.currentGambler = id;

        if ( id < vm.playersData.length ) {
          
          vm.currentGambler = vm.playersData[ id ];

        } else {
          
          DealerService.currentGambler = 0;
          vm.currentGambler            = {};
          vm.readyToGo                 = true;
          vm.currentPlayer             = vm.playersData[ 0 ];

        }
      }

      vm.wager = '';
    
    }

    function playerAction( player, action ) {
      DealerService.dealerAI( player, action );
    }

    ///////////// $broadcast events
    $scope
      .$on( 'next-player', function( evt, player ) {

        if ( player.id < vm.playersData.length ) {
          vm.currentPlayer = vm.playersData[ player.id ];
        } else {

          RoomService.playersData  = vm.playersData;

          $state
            .go( 'result' );
        }

      });

    ///////////// Start
    _init();
  
  }

}());
