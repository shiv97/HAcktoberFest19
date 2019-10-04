const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const db = require('./queries')
const port = 8000
var path = require("path")
app.use(bodyParser.json())
app.use(
  bodyParser.urlencoded({
    extended: true,
  })
)
app.get('/', (request, response) => {
  response.sendFile(path.join( __dirname,'index.html' ));
})

app.get('/users', db.getUsers)

app.listen(port, () => {
  console.log(`App running on port ${port}.`)
})