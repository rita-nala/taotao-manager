<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品展示页面</title>
</head>
<body>

<script type="text/html" id="toolbarDemo">
	<div class="layui-btn-container">
		<button class="layui-btn layui-btn-sm" lay-event="del">删除</button>
		<button class="layui-btn layui-btn-sm" lay-event="up">上架</button>
		<button class="layui-btn layui-btn-sm" lay-event="low">下架</button>
	</div>
	<div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">标题</label>
      <div class="layui-input-inline">
        <input type="text" name="title" id="title" placeholder="请输入商品标题" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">卖点</label>
      <div class="layui-input-inline">
        <input type="text" name="sellPoint" id="sellPoint"  placeholder="请输入商品卖点" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">价格</label>
      <div class="layui-input-inline">
        <input type="tel" name="price" id="price"  placeholder="请输入商品价格" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <button type="submit" class="layui-btn" lay-event="search" lay-submit="" data-type="getInfo" lay-filter="demo1">搜索</button>
    </div>
  </div>
</script>
	<table class="layui-hide" id="tbItem" lay-filter="test"></table>
<script>
    var table;
	layui.use('table', function(){
    table = layui.table;
  
  table.render({
    elem: '#tbItem'
    ,url:'/item/showItem'
    ,id:'search'
    ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
    	,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
    	      title: '提示'
    	      ,layEvent: 'LAYTABLE_TIPS'
    	      ,icon: 'layui-icon-tips'
    	    }]
  	,title: '用户数据表'
    ,cols: [
            [
      {type:'checkbox'}
      ,{field:'id', width:80, title: '商品ID', sort: true}
      ,{field:'title', minWidth: 100, title: '商品标题'}
      ,{field:'cId', width:80, title: '叶子类目', sort: true}
      ,{field:'sellPoint', minWidth: 100, title: '卖点', sort: true}
      ,{field:'price', width:80, title: '价格'}
      ,{field:'num', title: '库存数量', width:80}
      ,{field:'barcode', width:80, title: '条形码', sort: true}
      ,{field:'status', width:80, title: '状态',
    	  templet:function(d){
    		  if (d.status==1){
	    			return "正常"
	    		} else if (d.status==2){
	    			return "下架"
	    		} else if (d.status==0){
	    			return "删除"
	    		}
      }, sort: true}
      ,{field:'created', minWidth: 100, title: '创建时间',templet:'<div>{{ layui.util.toDateString(d.created, "yyyy-MM-dd HH:mm:ss") }}</div>', sort: true}
      ,{field:'updated', minWidth: 100, title: '修改时间',templet:'<div>{{ layui.util.toDateString(d.updated, "yyyy-MM-dd HH:mm:ss") }}</div>', sort: true}
    ]
            ]
    ,page: true
    
  });
//头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'del':
        var data = checkStatus.data;
        //JSON.stringify(data)
        $.ajax({
            type: "POST",
            url: "/item/itemDel",
            contentType: "application/json;charset=utf-8",
            data:JSON.stringify(data),
            dataType: "json",
            success:function (message) {
               if (message.status==200) {
					layer.alert('删除商品成功');
					table.reload('tbItem',{})
				}else{
					layer.alert(message.msg);
				}
            },
            
        });
      break;
      case 'up':
          var data = checkStatus.data;
          //JSON.stringify(data)
          $.ajax({
              type: "POST",
              url: "/item/itemUp",
              contentType: "application/json;charset=utf-8",
              data:JSON.stringify(data),
              dataType: "json",
              success:function (message) {
                 if (message.status==200) {
  					layer.alert(message.msg);
  					table.reload('tbItem',{})
  				}else{
  					layer.alert(message.msg);
  				}
              },
              
          });
        break;
      case 'low':
          var data = checkStatus.data;
          //JSON.stringify(data)
          $.ajax({
              type: "POST",
              url: "/item/itemlow",
              contentType: "application/json;charset=utf-8",
              data:JSON.stringify(data),
              dataType: "json",
              success:function (message) {
                 if (message.status==200) {
  					layer.alert(message.msg);
  					table.reload('tbItem',{})
  				}else{
  					layer.alert(message.msg);
  				}
              },
              
          });
        break;
      case 'search':
    	  var sellPoint=$("#sellPoint").val();
    	  var title=$("#title").val();
    	  var price=$("#price").val();
    	  table.reload('search', { //表格的id
              url:'/item/searchItem',
              where: {
            	  sellPoint:sellPoint,
            	  title:title,
            	  price:price
              },
    	  page:{
    		  curr:1
    	  }
          });
        break;
      
    };
  });
});
	
   
</script>
</body>
</html>