/*
 * ??????:
 * window.wxc.Pop(popHtml, [type], [options])
 * popHtml:html?????
 * type:window.wxc.xcConfirm.typeEnum?????????
 * options:??????
 * ???:
 * 1. window.wxc.xcConfirm("??????<span>lalala</span>");
 * 2. window.wxc.xcConfirm("???","success");
 * 3. window.wxc.xcConfirm("?????","input",{onOk:function(){}})
 * 4. window.wxc.xcConfirm("?????",{title:"?????"})
 */
(function($){
	window.wxc = window.wxc || {};
	window.wxc.xcConfirm = function(popHtml, type, options) {
	    var btnType = window.wxc.xcConfirm.btnEnum;
		var eventType = window.wxc.xcConfirm.eventEnum;
		var popType = {
			info: {
				title: "信息",
				icon: "0 0",
				btn: btnType.ok
			},
			success: {
				title: "成功",
				icon: "0 -48px",
				btn: btnType.ok
			},
			error: {
				title: "错误",
				icon: "-48px -48px",
				btn: btnType.ok
			},
			confirm: {
				title: "确认",
				icon: "-48px 0",//??????
				btn: btnType.okcancel
			},
			warning: {
				title: "警告",
				icon: "0 -96px",//??????
				btn: btnType.okcancel
			},
			input: {
				title: "输入",
				icon: "",
				btn: btnType.ok
			},
			custom: {
				title: "",
				icon: "",
				btn: btnType.ok
			}
		};
		var itype = type ? type instanceof Object ? type : popType[type] || {} : {};//????????????:??????
		var config = $.extend(true, {
			//????
			title: "", //?????????
			icon: "", //???
			btn: btnType.ok, //???,????????
			//???
			onOk: $.noop,//??????????????
			onCancel: $.noop,//??????????????
			onClose: $.noop//???????????,?????????
		}, itype, options);
		
		var $txt = $("<p>").html(popHtml);//??????dom
		var $tt = $("<span>").addClass("tt").text(config.title);
		var icon = config.icon;
		var $icon = icon ? $("<div>").addClass("bigIcon").css("backgroundPosition",icon) : "";
		var btn = config.btn;
		
		var popId = creatPopId();
		
		var $box = $("<div>").addClass("xcConfirm");//?????????
		var $layer = $("<div>").addClass("xc_layer");//?????
		var $popBox = $("<div>").addClass("popBox");//??????
		var $ttBox = $("<div>").addClass("ttBox");//?????????
		var $txtBox = $("<div>").addClass("txtBox");//???????????
		var $btnArea = $("<div>").addClass("btnArea");//??????
		
		var $ok = $("<a>").addClass("sgBtn").addClass("ok").text("确定");//??????
		var $cancel = $("<a>").addClass("sgBtn").addClass("cancel").text("关闭");//??????
		var $input = $("<input>").addClass("inputBox");//?????
		var $clsBtn = $("<a>").addClass("clsBtn");//??????
		
		var btns = {
			ok: $ok,
			cancel: $cancel
		};
		
		init();
		
		function init(){
			if(popType["input"] === itype){
				$txt.append($input);
			}
			
			creatDom();
			bind();
		}
		
		function creatDom(){
			$popBox.append(
				$ttBox.append(
					$clsBtn
				).append(
					$tt
				)
			).append(
				$txtBox.append($icon).append($txt)
			).append(
				$btnArea.append(creatBtnGroup(btn))
			);
			$box.attr("id", popId).append($layer).append($popBox);
			$("body").append($box);
		}
		
		function bind(){
			$ok.click(doOk);
			
			$(window).bind("keydown", function(e){
				if(e.keyCode == 13) {
					if($("#" + popId).length == 1){
						doOk();
					}
				}
			});
			
			$cancel.click(doCancel);
			
			$clsBtn.click(doClose);
		}

		function doOk(){
			var $o = $(this);
			var v = $.trim($input.val());
			if ($input.is(":visible"))
		        config.onOk(v);
		    else
		        config.onOk();
			$("#" + popId).remove(); 
			config.onClose(eventType.ok);
		}
		
		function doCancel(){
			var $o = $(this);
			config.onCancel();
			$("#" + popId).remove(); 
			config.onClose(eventType.cancel);
		}
		
		function doClose(){
			$("#" + popId).remove();
			config.onClose(eventType.close);
			$(window).unbind("keydown");
		}
		
		function creatBtnGroup(tp){
			var $bgp = $("<div>").addClass("btnGroup");
			$.each(btns, function(i, n){
				if( btnType[i] == (tp & btnType[i]) ){
					$bgp.append(n);
				}
			});
			return $bgp;
		}

		function creatPopId(){
			var i = "pop_" + (new Date()).getTime()+parseInt(Math.random()*100000);//??????
			if($("#" + i).length > 0){
				return creatPopId();
			}else{
				return i;
			}
		}
	};
	
	window.wxc.xcConfirm.btnEnum = {
		ok: parseInt("0001",2),
		cancel: parseInt("0010",2),
		okcancel: parseInt("0011",2)
	};
	
	window.wxc.xcConfirm.eventEnum = {
		ok: 1,
		cancel: 2,
		close: 3
	};
	
	window.wxc.xcConfirm.typeEnum = {
		info: "info",
		success: "success",
		error:"error",
		confirm: "confirm",
		warning: "warning",
		input: "input",
		custom: "custom"
	};

})(jQuery);