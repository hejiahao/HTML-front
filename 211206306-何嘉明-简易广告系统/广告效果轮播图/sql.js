
    function sql(response) {
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: '123456',
            database: 'advshow'
        });
        console.log("连接成功！！")
        connection.connect();

        connection.query('SELECT * from turnadv', function (error, results, fields) {
            if (error) throw error;
            //console.log(results);
            // var temp=new String(results[0].advNote);
            //var propertys = Object.getOwnPropertyNames(results[0])[ 'advNote', 'advImg', 'advUrl', 'timeout' ]
            // var res = [
            //     results[0], '+',
            //     results[1]
            // ];
            var res = JSON.stringify(results);


            var advInfoItems='{"advInfos":'+res+'}';
            //console.log(advInfoItems);
            setTimeout(function () {
                response.writeHead("200","{'content-type':'application/json'}"); //MIME类型
                response.end(advInfoItems);

            },100);

            //return fa;
        });
        //var advInfoItems='{advInfos:'+fa+'}';
        // setTimeout(function () {
        //     response.writeHead("200","{'content-type':'application/json'}"); //MIME类型
        //     response.end(advInfoItems);
        //
        // },100);

    }
exports.sql=sql;