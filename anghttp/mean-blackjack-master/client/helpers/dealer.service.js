(function() {

  'use strict';

  angular
    .module( 'blackjack' )
    .service( 'DealerService', DealerService );

  DealerService.$inject = [
    'RoomService',
    '$rootScope'
  ];

  function DealerService( RoomService, $rootScope ) {
  
    var self = this;

    ///////////// Properties
    self.currentGambler  = 0;
    self.currentPlayer   = 0;
    self.readyToGo       = false;
    self.deck            = [];
    self.dealerData      = { hand : [], score : 0, stand : false };

    ///////////// Public Methods
    self.createDeck      = createDeck;
    self.giveCard        = giveCard;
    self.distributeCards = distributeCards;
    self.dealerAI        = dealerAI;
    self.resetValues     = resetValues;

    ///////////// Private Methods
    var _handleHit       = _handleHit;
    var _handleStand     = _handleStand;
    var _handleBust      = _handleBust;
    var _calculateScore  = _calculateScore;

    ///////////// Functions Declaration
    function createDeck() {

      self.deck = [];
    
      var typeOfCards = [ 
        'A',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9',
        '10',
        'J',
        'Q',
        'K'
      ];
      var typeOfSuits = [
        '♣',
        '♥',
        '♠',
        '♦'
      ];

      typeOfCards
        .forEach( function( card ) {
        
          typeOfSuits
            .forEach( function( suit ) {

              self
                .deck
                .push({
                  name  : card,
                  suit  : suit
                });
           
            });
        
        });

      return self.deck;

    }

    function giveCard( deckLength, player ) {

      var random = _randomNumberGenerator( 0, deckLength );
    
      player
        .hand
        .push( self.deck.splice( random, 1 )[ 0 ]);

      if ( player.id ) {
        RoomService.playersData[ player.id - 1 ] = player;
      }
    
    }

    /*
    *
    * Return a random number between min and max
    *
    * @param {number} min - inclusive
    * @param {number} max - exclusive
    *
    */
    function _randomNumberGenerator( min, max ) {  
      return Math.floor( Math.random() * ( max - min )) + min;  
    }

    /*
    *
    *  Give 2 cards per player + 2 cards for dealer
    *
    * @param {Array} players
    *
    */
    function distributeCards( players ) {

      players
        .push({ 
          hand  : [], 
          score : 0,
          stand : false
        });

      players
        .forEach( function( player ) {
        
          self
            .giveCard( self.deck.length, player );
          self
            .giveCard( self.deck.length, player );

          player.score = _calculateScore( player.hand );
        
        });

      self.dealerData = players.splice( players.length - 1, 1 )[ 0 ];

      return players;
    
    }

    /**
    *
    * Management of the game
    *
    * @param {Object} player
    * @param {String} action - "hit" or "stand"
    *
    **/
    function dealerAI( player, action ) {

      if ( action === 'hit' && !player.stand && player.score < 21 ) {
        _handleHit( player );
      } else {
        _handleStand( player );
      }

    }

    /**
    *
    * Calculate the total score of the player's hand
    *
    * @param {Array} hand - Array with card objects
    *
    **/    
    function _calculateScore( hand ) {

      var score  = 0;
      var bonusA = 0;
      var finish = false;

      hand
        .forEach( function( card ) {

          if ( card.name === 'A' ) {

            if ( score >= 11 ) {
              score += 1;
            } else {
              score  += 11;
              bonusA += 10;
            }

          } else if ( card.name === 'J' || card.name === 'Q' || card.name === 'K' ) {

            score += 10;

          } else {

            score += Number( card.name, 10 );

          }

        });

      while ( !finish ) {

        if ( bonusA <= 0 ) {
          finish = true;
        } else if ( bonusA > 0 && score <= 21 ) {
          finish = true;
        } else if ( bonusA > 0 && score > 21 ) {
          score  -= 10;
          bonusA -= 10;
        }
        
      }

      return score;

    }

    function _handleHit( player ) {

      var totalScore = 0;

      self
        .giveCard( self.deck.length, player );

      totalScore   = _calculateScore( player.hand );
      player.score = totalScore; 

      if ( totalScore >= 21 ) {

        player.stand = true;

        if ( player.id ) {

          RoomService
            .playersData[ player.id - 1 ] = player;

          $rootScope
            .$broadcast( 'next-player', player );

        }

      }

    }

    function _handleStand( player ) {

      player.stand = true;

      RoomService
        .playersData[ player.id - 1 ] = player;

      $rootScope
        .$broadcast( 'next-player', player );

    }

    function resetValues() {

      DealerService.readyToGo      = false;
      DealerService.currentGambler = 0;
      DealerService.currentPlayer  = 0;

    }
  
  }

}());
