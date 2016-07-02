
//

// Pipelining function for DataTables. To be used to the `ajax` option of DataTables

// 
$.fn.dataTable.pipeline = function ( opts ) {

    // Configuration options
    var conf = $.extend( {

        pages: 3,     // number of pages to cache

        url: '',      // script url

        data: null,   // function or object with parameters to send to the server

                      // matching how `ajax.data` works in DataTables
        
        method: '' // Ajax HTTP method

    }, opts );

    // Private variables for storing the cache

    var cacheLower = -1;

    var cacheUpper = null;

    var cacheLastRequest = null;

    var cacheLastJson = null;

 
    
    return function ( request, drawCallback, settings ) {

        var ajax          = false;

        var requestStart  = request.start;

        var drawStart     = request.start;

        var requestLength = request.length;

        var requestEnd    = requestStart + requestLength;

         

        if ( settings.clearCache ) {

            // API requested that the cache be cleared

            ajax = true;

            settings.clearCache = false;

        }

        else if ( cacheLower < 0 || requestStart < cacheLower || requestEnd > cacheUpper ) {

            // outside cached data - need to make a request

            ajax = true;

        }

        else if ( JSON.stringify( request.order )   !== JSON.stringify( cacheLastRequest.order ) ||

                  JSON.stringify( request.columns ) !== JSON.stringify( cacheLastRequest.columns ) ||

                  JSON.stringify( request.search )  !== JSON.stringify( cacheLastRequest.search )

        ) {

            // properties changed (ordering, columns, searching)

            ajax = true;

        }

         

        // Store the request for checking next time around

        cacheLastRequest = $.extend( true, {}, request );

 

        if ( ajax ) {

            // Need data from the server

            if ( requestStart < cacheLower ) {

                requestStart = requestStart - (requestLength*(conf.pages-1));

 

                if ( requestStart < 0 ) {

                    requestStart = 0;

                }

            }

             

            cacheLower = requestStart;

            cacheUpper = requestStart + (requestLength * conf.pages);

 

            request.start = requestStart;

            request.length = requestLength*conf.pages;

 

            // Provide the same `data` options as DataTables.

            if ( $.isFunction ( conf.data ) ) {

                // As a function it is executed with the data object as an arg

                // for manipulation. If an object is returned, it is used as the

                // data object to submit

                var d = conf.data( request );

                if ( d ) {

                    $.extend( request, d );

                }

            }

            else if ( $.isPlainObject( conf.data ) ) {

                // As an object, the data given extends the default

                $.extend( request, conf.data );

            }
            //start 自定义加的 给request赋值 后台好获取
            
            
            //end

            settings.jqXHR = $.ajax( {

                "type":     conf.method,

                "url":      conf.url,

                "data":     request,

                "dataType": "json",

                "cache":    false,
                "success":  function ( json ) {
                    cacheLastJson = $.extend(true, {}, json);
                    if ( cacheLower != drawStart ) {
                        json.data.splice( 0, drawStart-cacheLower );
                    }
                    json.data.splice( requestLength, json.data.length );
                   
                    drawCallback( json );
                }
                

            } );

        }

        else {

            json = $.extend( true, {}, cacheLastJson );

            json.draw = request.draw; // Update the echo for each response

            json.data.splice( 0, requestStart-cacheLower );

            json.data.splice( requestLength, json.data.length );
            drawCallback(json);

        }

    }
};

// Register an API method that will empty the pipelined data, forcing an Ajax

// fetch on the next draw (i.e. `table.clearPipeline().draw()`)

$.fn.dataTable.Api.register( 'clearPipeline()', function () {

    return this.iterator( 'table', function ( settings ) {

        settings.clearCache = true;

    } );

} );
//例子
$(document).ready(function() {


	    $('#dataTables-example1').dataTable( {

	        "processing": true,

	        "serverSide": true,

	        "ajax": $.fn.dataTable.pipeline( {

	            url: "../log/getDataList.action?rand="+Math.random() ,
				method:"POST",
	            pages: 5 // number of pages to cache
	        } ),
            "columns": [
        				{ data: 'lid', "visible": false },//隐藏 可在后面添加逗号隔开
        				{ data: 'cname' },
        				{ data: 'deptname' },
        				{ data: 'uname' },
        				{ data: 'action' },
        				{ data: 'page' },
        				{ data: 'tablename' },
        				{ data: 'dataid' },
        				{ data: 'dataname' },
        				{ data: 'beforeupdate' },
        				{ data: 'afterupdate' },
        				{ data: 'createdate' },
        			],
        	 "oLanguage": {
	    	"sProcessing": "正在加载中......",
	    	"sLengthMenu": "每页显示 _MENU_ 条记录",
	    	"sZeroRecords": "对不起，查询不到相关数据！",
	    	"sEmptyTable": "表中无数据存在！",
	    	"sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条",
	    	"sInfoFiltered": " (数据表中共有 _MAX_ 条记录)",
	    	"sSearch": "搜索：",
	    	"oPaginate": {
	    	    "sFirst": "首页",
	    	    "sPrevious": "上一页",
	    	    "sNext": "下一页",
	    	    "sLast": "末页"
	    	}
	    	 }

	    } );

	} ); 
	function checkEndTime(date,st,et){
	    var startTime=$(st).val();  
	    var start=new Date(startTime.replace("-", "/").replace("-", "/"));  
	    var endTime=$(et).val();  
	    var end=new Date(endTime.replace("-", "/").replace("-", "/"));  
	    if(end<start){  
	        return false;  
	    }  
	    return true;  
	}  