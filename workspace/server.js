const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const jsonFile = require('jsonfile');

const PORT = 3000;
const app = express();
app.use(bodyParser.json());
app.use(cors());

var fileName = "data/employees.json"
const data = jsonFile.readFileSync(fileName);

app.get("/test", function (req, resp) {
  resp.send("Hello From Server..");
}

);
app.get("/list", function (req, resp) {
  resp.contentType("json");
  resp.send(data);
}

);
app.get("/find", function (req, resp) {
  let id = req.query.id;
  console.log('id is ' + id)
  resp.contentType('json');
  console.log(data);
  for (let i = 0; i < data.length; i++) {
    if (id == data[i].id) {
      resp.send(data[i]);
    }// else {
     // resp.send({ "status": "No Emp Found" });
    //}
  }
}
);
app.post('/enroll', function (req, res) {
  console.log(req.body)
  res.status(200).send({ "message": "Data received" });
})
app.listen(PORT, () => console.log("Server is running.." + PORT));