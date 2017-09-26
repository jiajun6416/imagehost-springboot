﻿$(function() {
	$(".qq")
			.click(
					function() {
						getconnecting('https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=100271575&redirect_uri=http://www.tuzhan.com/connect-tx.do&scope=get_user_info,add_share,get_info,add_pic_t,add_idol');
					});
	$(".sina")
			.click(
					function() {
						getconnecting('https://api.weibo.com/oauth2/authorize?client_id=843887157&response_type=code&redirect_uri=http://www.tuzhan.com/connect-xl.do');
					});
	$(".renren")
			.click(
					function() {
						getconnecting('https://graph.renren.com/oauth/authorize?client_id=f5d67f69833c4179b4e10a6e47d22a0a&redirect_uri=http://www.tuzhan.com/connect-rr.do&response_type=code&scope=publish_feed publish_share');
					});
	$(".kaixin")
			.click(
					function() {
						getconnecting('http://api.kaixin001.com/oauth2/authorize?client_id=8500894183902c301fda1674c0f47afc&response_type=code&redirect_uri=http://www.tuzhan.com/connect-kx.do&scope=basic user_birthday user_intro send_feed');
					});
	$(".163")
			.click(
					function() {
						getconnecting('https://api.t.163.com/oauth2/authorize?client_id=ye5fgrxHhTbtwEwo&redirect_uri=http://www.tuzhan.com/connect-wy.do&response_type=code');
					});
	$(".sohu").click(function() {
		getconnecting('http://www.tuzhan.com/connect2sh.do');
	});
	$(".baidu")
			.click(
					function() {
						getconnecting('https://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=eOCpbiCHT1vvi0GdEa6Z1xG0&redirect_uri=http://www.tuzhan.com/connect-bd.do');
					});
	$(".douban").click(function() {
		getconnecting('http://www.tuzhan.com/connect2db.do');
	});
	var getconnecting = function(url) {
		var form = $("<form>");
		var ua = url.split("?");
		if (ua.length > 1) {
			var qp = ua[1].split("&");
			$.each(qp, function(i, p) {
				var kv = p.split("=");
				if (kv.length > 1) {
					var input = $("<input>");
					input.attr("type", "hidden");
					input.attr("name", kv[0]);
					input.attr("value", kv[1]);
					input.appendTo(form);
				}
			});
		}
		form.attr("action", ua[0]);
		form.attr("method", "get");
		form.attr("target", '_blank');
		form.appendTo(document.body);
		form.submit();
		form.empty();
		form.remove();
	};
});