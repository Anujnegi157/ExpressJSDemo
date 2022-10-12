const express = require('express');
const Joi = require('joi');
const dotenv= require('dotenv');

dotenv.config();
const app = express();
app.use(express.json());
let courses = [
 {id :1,name :"DBMS"},
 {id :2,name :"JAVA"},
 {id :3,name :"OOPS"},
]
app.get('/',(req,res)=>{
  res.send("Hello World");
});
app.get('/api/courses',(req,res)=>{
   res.send(courses);
});
app.get('/api/courses/:id',(req,res)=>{
  // res.send(req.params.month);
 const course  =  courses.find(c=>c.id==parseInt(req.params.id));
 if(!course){
  res.send("404 found");
 }else{
  res.send(course);
 }
 
  // res.send()
})


app.post('/api/courses',(req,res)=>{
  // const schema={
  //   name : Joi.string().min(3).required()
  // }
  // const result = Joi.valid(req.body,schema);
  // console.log(result);
  // if(result.error){
  //   res.send("404");
  //   return;
  // }
  const course = {
   id:courses.length+1,
   name: req.body.name
  };
  // const course = {
  //   id : "4",
  //   name : "DSA"
  // }
  // console.log();
  courses.push(course);
  console.log("line 45",courses);
  res.send(course);
})
app.put('/api/courses/:id',(req,res)=>{
  const course  =  courses.find(c=>c.id==parseInt(req.params.id));
 if(!course){
  res.send("404 found");
 }
const schema={
  name : Joi.string().min(3).required()
}
const result = Joi.valid(req.body,schema);
console.log(result);
if(result.error){
  res.send("404");
  return;
}
  course.name = req.body.name;
  res.send(course);

})
// app.delete()
const port = process.env.PORT || 3000;
app.listen(port,()=>{
  console.log(`Working Listing on Port ${port}`);
});