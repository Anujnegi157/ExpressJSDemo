const mongoose = require("mongoose");
console.log("working");
const secret = require('../Secret/secret');
// console.log(secret.DB_LINK);
mongoose.connect(secret.DB_LINK,{
  // userNewUrlParser : true,
  // userCreateIndex : true, 
  // userUnifiedTopology : true,

   
}).then(function(db){
  // console.log(db);
  console.log("db");
}).catch(function(err){
  console.log("error",err);
})


const reviewSchema = new mongoose.Schema({
  id : {
    type : Number,
    require : true,
    unique : true,
  },
  name :{
    type  : String,
    require : true
  },
  price :{
    type : String,
    require : true
  },
  delivery : {
    type : Boolean,
    require : true
  },
  meal : {
    type : Number,
    require : true
  },
  description :{
    type : String,
    require : true
  }
})

const reviewModel =  mongoose.model("reviewModel",reviewSchema);

//  (async function revire(){
//    let obj = {
//     review : "5"
//    }
//    let data = await reviewModel.create(obj);
//    console.log("data",data);
//  })();