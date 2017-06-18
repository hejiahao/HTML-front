var http = require('http');
var fs= require('fs');
var sql=require('./sql');
// var url = require('url');
// var qs = require('querystring');

var server=http.createServer(function (request, response) {
    if (request.url=="/"){
        fs.readFile('./turn-show2.html',function(err,data){
                if(err)
                    throw err;
                response.writeHead(200,{"content-type":"text/html"});
                response.end(data);

            }
        );
    } else if(request.url.substr(0,request.url.lastIndexOf("/")) == '/images'){
        fs.readFile("."+request.url,function(err,data){
            if(err)
                throw err;
            response.writeHead("200","{'content-type':'image/png'}"); //MIME类型
            response.write(data);
            response.end();
        });
    }  else if(request.url == '/node_modules/jquery/dist/jquery.min.js'){
        fs.readFile('./node_modules/jquery/dist/jquery.min.js',function(err,data){
            if(err)
                throw err;
            response.writeHead(200,"{'content-type':'text/javascript'}");
            response.end(data);
        });
    }else if(request.url == '/loadAdvData'){ //提供广告信息数据

        //console.log("hihi ");
       // 混合字面量 对象-数组-对象
       //  var advInfoItems ='{"advInfos":['+
       //      '{"advImg":"banner-1.png","advNote":"访问网易","advUrl":"http://www.163.com","timeout":100},'+
       //      '{"advImg":"banner-2.png","advNote":"访问福州大学","advUrl":"http://www.fzu.edu.cn","timeout":200},'+
       //      '{"advImg":"banner-3.png","advNote":"访问京东商城","advUrl":"http://www.jd.com","timeout":300},'+
       //      '{"advImg":"jd-1.png","advNote":"访问亚马逊","advUrl":"http://www.amazon.com","timeout":400},'+
       //      '{"advImg":"jd-2.png","advNote":"访问苹果美国","advUrl":"http://www.apple.com","timeout":500}'+
       //  ']}';

      sql.sql(response);

       // var advInfoItems='{advInfos:'+fa+'}';
       //         setTimeout(function () {
            //      response.writeHead("200","{'content-type':'application/json'}"); //MIME类型
            //      response.end(advInfoItems);
            //
            //  },100);

    }
    else if (request.url=="/backStage"){
        fs.readFile('./backStage.html',function(err,data){
                if(err)
                    throw err;
                response.writeHead(200,{"content-type":"text/html"});
                response.end(data);

            }
        );
   }
   //else if(request.url=="/load"){  //get方式提交表单时 action里面不能用url传值, post则可以这样传
   //      var pathname = url.parse(request.url).pathname;
   //      console.log(pathname);
   //  }
   //时间来不及做
        // else if (request.method.toUpperCase() == 'GET'){
    //     response.writeHead(200, {'Content-Type': 'text/plain;charset=utf-8'});
    //     var params = url.parse(request.url, true).query;
    //     console.log(params.advNote);
    //     response.write(params.advNote);
    //     response.write("\n");
    //     response.write( params.advUrl);
    //     response.end();
    // }
    else if(request.url == '/node_modules/bootstrap/dist/css/bootstrap.min.css'){
        fs.readFile('./node_modules/bootstrap/dist/css/bootstrap.min.css',function(err,data){
            if(err)
                throw err;
            response.writeHead(200,"{'content-type':'text/css ;charset=utf-8'}");
            response.end(data);
        });
    }
    else
    {
        response.end("invalid url");
    }

});

server.listen(3001);
console.log('Server running at http://localhost:3001/');