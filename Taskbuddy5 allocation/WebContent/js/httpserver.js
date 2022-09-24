var express=require('express');
var app=express();
var path=require('path');
app.use(express.static(path.join(__dirname,'public'))); //folder
app.get('/',function(req,res){
    res.sendFile(path.join(__dirname + '/index.html'));
    
});
app.get('/hello',function(req,res){
    res.send('Hello World');
    
});
var server =app.listen(8000,function(){
var host=server.address().address
var port=server.address().port
console.log("listening at http://localhost:8000",host,port);

})