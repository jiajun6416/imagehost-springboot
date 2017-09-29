 $(function(){
	/*排序后复制*/
	$('#sortCopy').click(function(){
		if($("input[type='checkbox']:checked").length<2){
			$.dialog.showMsgLayer('提示', '至少选择两张图片');return;
		}
		$('#copyWindow .gbin1-list').empty();
		var str='';
		$("input[type='checkbox']:checked").each(function(i){
			var findurl=$(this).parents('.c_p_l_c_i').attr('data-findurl');
			var turl=$(this).parents('.c_p_l_c_i').attr('data-turl');
			var surl=$(this).parents('.c_p_l_c_i').attr('data-surl');
			var linkurl=$(this).parents('.c_p_l_c_i').attr('data-linkurl');
			str+='<li><img src="'+turl+'" data-turl="'+turl+'" data-surl="'+surl+'" data-linkurl="'+linkurl+'" data-findurl="'+findurl+'" /></li>';
		});
		$('#copyWindow .gbin1-list').append(str);
		$('#copyWindow').show();
		$('.gbin1-list').sortable().bind('sortupdate', function() {
			$('#msg').fadeIn(200).delay(1000).fadeOut(200);
		});
	});
	$('.sortCopyBtn_html').on('mouseover',function(){
		$(this).zclip({
			path : 'http://www.tietuku.com/static/js/ZeroClipboard.swf',
			copy : function(){
				return copytext_sort_html($(this).attr('data-id'));
			},
			afterCopy:function(){
				$.prompt.show('复制成功');
				setTimeout(function(){$.prompt.hidden()},1000);
			}
		});
	})
	$('.sortCopyBtn_ubb').on('mouseover',function(){
		$(this).zclip({
			path : 'http://www.tietuku.com/static/js/ZeroClipboard.swf',
			copy : function(){
				return copytext_sort_ubb($(this).attr('data-id'));
			},
			afterCopy:function(){
				$.prompt.show('复制成功');
				setTimeout(function(){$.prompt.hidden()},1000);
			}
		});
	})
    $(".copybtn").on('mouseover',function(){
       if(!$(this).data('init')){
		   $(this).zclip({
				path : 'http://www.tietuku.com/static/js/ZeroClipboard.swf',
				copy : function(){
				   return $(this).attr('data-url');
				}
			});
		   $(this).data('init',true)
	   }
	})
	$('#cpyspan ul li').on('mouseover',function(){
		$(this).zclip({
			path : 'http://www.tietuku.com/static/js/ZeroClipboard.swf',
			copy : function(){
				return copytext($(this).attr('id'));
			},
			afterCopy:function(){
				$("#cpyspan ul").addClass('hide');
				$.prompt.show('复制成功');
				setTimeout(function(){$.prompt.hidden()},1000);
			}
		});
	})
	$('#cpyspan_ubb ul li').on('mouseover',function(){
		$(this).zclip({
			path : 'http://www.tietuku.com/static/js/ZeroClipboard.swf',
			copy : function(){
				return copytext_ubb($(this).attr('id'));
			},
			afterCopy:function(){
				$("#cpyspan_ubb ul").addClass('hide');
				$.prompt.show('复制成功');
				setTimeout(function(){$.prompt.hidden()},1000);
			}
		});
	})
});
function copytext_sort_html(obj){
	var str='<p style="text-align:center" contentEditable=true>';
	$(".gbin1-list li img").each(function(i){
		var picurl='<img src="'+$(this).attr('data-'+obj)+'"/><br/>';
		str+=picurl;
	});
	str+='</p>';
	return str;
}
function copytext_sort_ubb(obj){
	var str='';
	$(".gbin1-list li img").each(function(i){
		var picurl='[img]'+$(this).attr('data-'+obj)+'[/img]';
		str+=picurl;
	});
	return str;
}
function copytext(obj){
	if($("input[type='checkbox']:checked").length<1){
		$.dialog.showMsgLayer('提示', '未选择图片');return;
	}
	var str='<p style="text-align:center" contentEditable=true>';
	$("input[type='checkbox']:checked").each(function(i){
		var picurl='<img src="'+$(this).parents('.c_p_l_c_i').attr('data-'+obj)+'" alt="'+$(this).parents('.c_p_l_c_i').find('.name_input').val()+'"/><br/>';
		str+=picurl;
	});
	str+='</p>';
	return str;
}
function copytext_ubb(obj){
	if($("input[type='checkbox']:checked").length<1){
		$.dialog.showMsgLayer('提示', '未选择图片');return;
	}
	var str='';
	$("input[type='checkbox']:checked").each(function(i){
		var picurl='[img]'+$(this).parents('.c_p_l_c_i').attr('data-'+obj)+'[/img]';
		str+=picurl;
	});
	return str;
}
var albumid='1352520';
$(function(){
	$('[name="order_by"]').change(function(){
		window.location.href="/manage/"+albumid+"?order="+$(this).val();
	});
	$('.name_input').hover(function(){
		$(this).select();
	}).focus(function(){
		$(this).select();
	});
	$('.check_box').change(function(){
		if($(this).attr('checked')){
			$(this).parents('.c_p_l_c_i').addClass('hover');
		}else{
			$(this).parents('.c_p_l_c_i').removeClass('hover');
		}
	});
	
})
function selectall(){
	$(".check_box").each(function(){
		$(this).attr("checked",true);
		$('.c_p_l_c_i').addClass('hover');
	});
}
function delall(){
	$(".check_box").each(function(){
		$(this).attr("checked",false);
		$('.c_p_l_c_i').removeClass('hover');
	});  
}
function antiall(){
	$(".check_box").each(function(){
		$(this).attr("checked",!this.checked);
		if($(this).attr('checked')){
			$(this).parents('.c_p_l_c_i').addClass('hover');
		}else{
			$(this).parents('.c_p_l_c_i').removeClass('hover');
		}
	});  
}
function delpic(pid){
	$.dialog.showFuncLayer(430, "确认删除", '确定要删除这张图片吗？', function () {
		if (getcookie('uid')) {
			$.post("/?m=Home&c=Index&a=delpic",{'pid':pid},function(t){
				if(t.status==1){
					$('#s'+pid).remove();
					$.dialog.hidden();
				}else{
					$.dialog.showMsgLayer("提示", t.info);
				}
			});
		}else{
			$.dialog.showMsgFuncLayer("登录失效", "登录已失效，请重新登录！", function () { showSignIn(); }, 1);
		}
	});
	
}
function editpicname(pid,name,oname){
	$.ajax({
		beforeSend: function () {
			if(name==oname){
				$.prompt.show('无变化');
				setTimeout(function(){$.prompt.hidden()},1000);
				return false;
			}
			if(name.length<2){
				$.prompt.show( '名称过短！');
				setTimeout(function(){$.prompt.hidden()},1000);
				return false;
			}
		},
		complete: function () {  },
		cache: false,
		data: { 'pid':pid,'pname':name },
		error: function () { $.dialog.showMsgLayer('系统异常', '对不起，系统出现异常，修改失败！'); },
		success: function (t) {
			if(t.status == 1){
				$.prompt.show('修改成功');
				setTimeout(function(){$.prompt.hidden()},1000);
			}else{
				$.dialog.showMsgLayer('提示', '登录超时，请重新登录');
			}
		},
		type: 'POST',
		url: '/?m=Home&c=User&a=saveTagCat'
	});
}
function movepics(){
	if($("input[type='checkbox']:checked").length<1){
		$.dialog.showMsgLayer('提示', '未选择图片');return false;
	}
	s = ' <div class="register_f_a" style="text-align:center;">移动到相册：<select name="albums"><option value="">--选择相册--</option>'+$('#hidealbum').html()+'</select></div>';
	$.dialog.showMsgFuncLayer("移动图片", s, function () {
		var pids='';
		var aid=$('[name="albums"]').val();
		if(!aid || aid==''){$.prompt.show('请选择相册');return false;}
		$("input[type='checkbox']:checked").each(function(i){
			pids += $(this).parents('.c_p_l_c_i').find('.check_box').attr('data-id')+',';
		});
		$.ajax({
			cache: false,
			data: { pids:pids ,aid:aid},
			error: function () { $.dialog.showMsgLayer('系统异常', '对不起，系统出现异常，修改失败！'); },
			success: function (t) {
				if(t.status == 1){
					$.prompt.show('移动成功');
					$.dialog.hidden();
					setTimeout(function(){window.location.reload()},1000);
				}else{
					$.dialog.showMsgLayer('提示', t.msg);
				}
			},
			type: 'post',
			url: '/?m=Home&c=User&a=movepics'
		});
	},0);
	
}
function delMuPic(){
	if($("input[type='checkbox']:checked").length<1){
		$.dialog.showMsgLayer('提示', '未选择图片');return false;
	}
	$.dialog.showFuncLayer(430, "确认删除", '确定要删除选中的图片吗？', function () {
		var pids='';
		$("input[type='checkbox']:checked").each(function(i){
			pids += $(this).parents('.c_p_l_c_i').find('.check_box').attr('data-id')+',';
		});
		$.post("/?m=Home&c=Index&a=delMuPic",{'pids':pids},function(t){
			if(t.status==1){
				$.prompt.show('删除成功');
				$.dialog.hidden();
				setTimeout(function(){window.location.reload()},1000);
			}else{
				$.dialog.showMsgLayer("提示", t.info);
			}
		});
		
	});
}