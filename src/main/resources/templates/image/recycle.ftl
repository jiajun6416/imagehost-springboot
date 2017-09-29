<#compress> <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回收站--${session_user_key.nickname}</title>
<#include 'common.ftl'>
<style>
.user_nav_a input {
	width: auto;
	padding: 3px 5px;
	height: 22px;
	font-size: 12px
}

.name_input {
	width: 112px;
	margin-right: 2px;
}

.button {
	padding: 2px 3px;
}

.c_p_l_c_i.hover {
	background-color: #D8F0BC
}
.imagename {
	font-size:12px;
	font-family:"微软雅黑";
	font-weight:bold;
}
</style>
<SCRIPT language="javascript"
	src="${basetPath}/static/js/useralbumphoto.js" type="text/javascript"></SCRIPT>
<SCRIPT language="javascript"
	src="${basetPath}/static/js/jquery.sortable.js" type="text/javascript"></SCRIPT>
</head>
<body>
	<#include "head.ftl">

	<DIV class="container">
		<DIV class="user">
			<DIV class="user_nav" style="position: fixed; top: 59px">
				<SPAN class="user_nav_a" style="width: 97%"> <b>相册管理</b> |
					默认相册 | <a href="/album/1352520">返回相册</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span style="float: right"> <a href="javascript:;"
						onclick="selectall()">全选</a> &nbsp;&nbsp; <a href="javascript:;"
						onclick="antiall()">反选</a> &nbsp;&nbsp; <a href="javascript:;"
						onclick="delall()">取消选择</a> &nbsp;&nbsp; <span id="cpyspan"
						class="cpyspan"> <input type="button" id="copyselected"
							value="复制HTML代码" class="cbtn upload_c_a_c_b_a_b" />
							<ul class="hide">
								<li id="turl">缩略图</li>
								<li id="surl">展示图</li>
								<li id="linkurl">原图</li>
							</ul>
					</span> <span id="cpyspan_ubb" class="cpyspan"> <input
							type="button" id="copyselected_ubb" value="复制UBB代码"
							class="cbtn upload_c_a_c_b_a_b" />
							<ul class="hide">
								<li id="turl">缩略图</li>
								<li id="surl">展示图</li>
								<li id="linkurl">原图</li>
							</ul>
					</span> <input type="button" id="sortCopy" value="排序后复制"
						class="cbtn upload_c_a_c_b_a_b" /> <input type="button"
						onclick="delMuPic()" value="删除" class="cbtn upload_c_a_c_b_a_b" />
				</span>
				</SPAN>
			</DIV>
			<DIV class="container_photo_list user_photo_list">
				<DIV class="c_p_l_col">
					<DIV class="c_p_l_c_i"
						data-linkurl="http://i4.bvimg.com/609510/f9f902f3d237ce62.png"
						data-surl="http://i4.bvimg.com/609510/f9f902f3d237ce62s.png"
						data-turl="http://i4.bvimg.com/609510/f9f902f3d237ce62t.jpg"
						data-findurl="29305021dee4582d" id="s25594649">
						<DIV class="c_p_l_c_i_a" style="height: 32px;">
							<label for="b25594649"> <IMG alt="jian"
								src="http://i4.bvimg.com/609510/f9f902f3d237ce62t.jpg"
								onload="if(($(this).parents('.c_p_l_c_i_a').height()<500)&&($(this).height()!=$(this).parents('.c_p_l_c_i_a').height())){$(this).parents('.c_p_l_c_i_a').height($(this).height())};" />
							</label>
						</DIV>
						<DIV class="c_p_l_c_i_b">
							<input type="checkbox" class="check_box" id="b25594649"
								data-id="25594649" /> <input type="text" value="jian"
								class="name_input" /> <input type="button" class="button"
								onclick="editpicname('25594649',$(this).prev().val(),'jian')"
								value="修改" title="修改图片名" />
						</DIV>
						<DIV class="c_p_l_c_i_b" style="margin-bottom: 4px">
							<input type="button" class="button copybtn"
								data-url="http://i4.bvimg.com/609510/f9f902f3d237ce62.png"
								value="原图" title="复制原图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/f9f902f3d237ce62s.png"
								value="展示图" title="复制展示图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/f9f902f3d237ce62t.jpg"
								value="缩略图" title="复制缩略图" /> <input type="button"
								class="button" onclick="delpic('25594649');return false"
								value="删除" title="删除" />
						</DIV>
						<DIV class="c_p_l_c_i_c"></DIV>
						<DIV class="c_p_l_c_i_d"></DIV>
						<DIV class="c_p_l_c_i_e"></DIV>
					</DIV>
				</DIV>
				<DIV class="c_p_l_col">
					<DIV class="c_p_l_c_i"
						data-linkurl="http://i4.bvimg.com/609510/2cac36508cfba8b5.png"
						data-surl="http://i4.bvimg.com/609510/2cac36508cfba8b5s.png"
						data-turl="http://i4.bvimg.com/609510/2cac36508cfba8b5t.jpg"
						data-findurl="5b5c16288fbd94b2" id="s25594652">
						<DIV class="c_p_l_c_i_a" style="height: 32px;">
							<label for="b25594652"> <IMG alt="login"
								src="http://i4.bvimg.com/609510/2cac36508cfba8b5t.jpg"
								onload="if(($(this).parents('.c_p_l_c_i_a').height()<500)&&($(this).height()!=$(this).parents('.c_p_l_c_i_a').height())){$(this).parents('.c_p_l_c_i_a').height($(this).height())};" />
							</label>
						</DIV>
						<DIV class="c_p_l_c_i_b">
							<input type="checkbox" class="check_box" id="b25594652"
								data-id="25594652" /> <input type="text" value="login"
								class="name_input" /> <input type="button" class="button"
								onclick="editpicname('25594652',$(this).prev().val(),'login')"
								value="修改" title="修改图片名" />
						</DIV>
						<DIV class="c_p_l_c_i_b" style="margin-bottom: 4px">
							<input type="button" class="button copybtn"
								data-url="http://i4.bvimg.com/609510/2cac36508cfba8b5.png"
								value="原图" title="复制原图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/2cac36508cfba8b5s.png"
								value="展示图" title="复制展示图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/2cac36508cfba8b5t.jpg"
								value="缩略图" title="复制缩略图" /> <input type="button"
								class="button" onclick="delpic('25594652');return false"
								value="删除" title="删除" />
						</DIV>
						<DIV class="c_p_l_c_i_c"></DIV>
						<DIV class="c_p_l_c_i_d"></DIV>
						<DIV class="c_p_l_c_i_e"></DIV>
					</DIV>
				</DIV>
				<DIV class="c_p_l_col">
					<DIV class="c_p_l_c_i"
						data-linkurl="http://i4.bvimg.com/609510/d9078a6ff95562e2.png"
						data-surl="http://i4.bvimg.com/609510/d9078a6ff95562e2s.png"
						data-turl="http://i4.bvimg.com/609510/d9078a6ff95562e2t.jpg"
						data-findurl="aa691999558e8577" id="s25594651">
						<DIV class="c_p_l_c_i_a" style="height: 32px;">
							<label for="b25594651"> <IMG alt="login (1)"
								src="http://i4.bvimg.com/609510/d9078a6ff95562e2t.jpg"
								onload="if(($(this).parents('.c_p_l_c_i_a').height()<500)&&($(this).height()!=$(this).parents('.c_p_l_c_i_a').height())){$(this).parents('.c_p_l_c_i_a').height($(this).height())};" />
							</label>
						</DIV>
						<DIV class="c_p_l_c_i_b">
							<input type="checkbox" class="check_box" id="b25594651"
								data-id="25594651" /> <input type="text" value="login (1)"
								class="name_input" /> <input type="button" class="button"
								onclick="editpicname('25594651',$(this).prev().val(),'login (1)')"
								value="修改" title="修改图片名" />
						</DIV>
						<DIV class="c_p_l_c_i_b" style="margin-bottom: 4px">
							<input type="button" class="button copybtn"
								data-url="http://i4.bvimg.com/609510/d9078a6ff95562e2.png"
								value="原图" title="复制原图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/d9078a6ff95562e2s.png"
								value="展示图" title="复制展示图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/d9078a6ff95562e2t.jpg"
								value="缩略图" title="复制缩略图" /> <input type="button"
								class="button" onclick="delpic('25594651');return false"
								value="删除" title="删除" />
						</DIV>
						<DIV class="c_p_l_c_i_c"></DIV>
						<DIV class="c_p_l_c_i_d"></DIV>
						<DIV class="c_p_l_c_i_e"></DIV>
					</DIV>
				</DIV>
				<DIV class="c_p_l_col">
					<DIV class="c_p_l_c_i"
						data-linkurl="http://i4.bvimg.com/609510/67e233e3a7d262cd.png"
						data-surl="http://i4.bvimg.com/609510/67e233e3a7d262cds.png"
						data-turl="http://i4.bvimg.com/609510/67e233e3a7d262cdt.jpg"
						data-findurl="72aa7a2c73e38614" id="s25594650">
						<DIV class="c_p_l_c_i_a" style="height: 82px;">
							<label for="b25594650"> <IMG alt="file_150320048"
								src="http://i4.bvimg.com/609510/67e233e3a7d262cdt.jpg"
								onload="if(($(this).parents('.c_p_l_c_i_a').height()<500)&&($(this).height()!=$(this).parents('.c_p_l_c_i_a').height())){$(this).parents('.c_p_l_c_i_a').height($(this).height())};" />
							</label>
						</DIV>
						<DIV class="c_p_l_c_i_b">
							<input type="checkbox" class="check_box" id="b25594650"
								data-id="25594650" /> <input type="text" value="file_150320048"
								class="name_input" /> <input type="button" class="button"
								onclick="editpicname('25594650',$(this).prev().val(),'file_150320048')"
								value="修改" title="修改图片名" />
						</DIV>
						<DIV class="c_p_l_c_i_b" style="margin-bottom: 4px">
							<input type="button" class="button copybtn"
								data-url="http://i4.bvimg.com/609510/67e233e3a7d262cd.png"
								value="原图" title="复制原图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/67e233e3a7d262cds.png"
								value="展示图" title="复制展示图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/67e233e3a7d262cdt.jpg"
								value="缩略图" title="复制缩略图" /> <input type="button"
								class="button" onclick="delpic('25594650');return false"
								value="删除" title="删除" />
						</DIV>
						<DIV class="c_p_l_c_i_c"></DIV>
						<DIV class="c_p_l_c_i_d"></DIV>
						<DIV class="c_p_l_c_i_e"></DIV>
					</DIV>
				</DIV>
				<DIV class="c_p_l_col">
					<DIV class="c_p_l_c_i"
						data-linkurl="http://i4.bvimg.com/609510/f531f6acd4b41f5e.jpg"
						data-surl="http://i4.bvimg.com/609510/f531f6acd4b41f5es.jpg"
						data-turl="http://i4.bvimg.com/609510/f531f6acd4b41f5et.jpg"
						data-findurl="6643b87a5c9a4d8a" id="s25594648">
						<DIV class="c_p_l_c_i_a" style="height: 93px;">
							<label for="b25594648"> <IMG alt="0cf264bcbaa97f"
								src="http://i4.bvimg.com/609510/f531f6acd4b41f5et.jpg"
								onload="if(($(this).parents('.c_p_l_c_i_a').height()<500)&&($(this).height()!=$(this).parents('.c_p_l_c_i_a').height())){$(this).parents('.c_p_l_c_i_a').height($(this).height())};" />
							</label>
						</DIV>
						<DIV class="c_p_l_c_i_b">
							<input type="checkbox" hidden="hidden" class="check_box"
								id="b25594648" data-id="25594648" />
							<label class="imagename">filename.222222222222222222</label>
							<!-- 	<input type="text" value="0cf264bcbaa97f" class="name_input" />
							<input type="button" class="button"
								onclick="editpicname('25594648',$(this).prev().val(),'0cf264bcbaa97f')" value="修改"
								title="修改图片名" /> -->
						</DIV>
						<DIV class="c_p_l_c_i_b" style="margin-bottom: 4px">
							<input type="button" class="button"
								onclick="delpic('25594648');return false" value="删除" title="删除" />
							<input type="button" class="button"
								onclick="delpic('25594648');return false" value="还原" title="还原" />
						</DIV>
						<DIV class="c_p_l_c_i_c"></DIV>
						<DIV class="c_p_l_c_i_d"></DIV>
						<DIV class="c_p_l_c_i_e"></DIV>
					</DIV>
				</DIV>
				<DIV class="c_p_l_col">
					<DIV class="c_p_l_c_i"
						data-linkurl="http://i4.bvimg.com/609510/432575788e390fa3.gif"
						data-surl="http://i4.bvimg.com/609510/432575788e390fa3s.gif"
						data-turl="http://i4.bvimg.com/609510/432575788e390fa3t.jpg"
						data-findurl="085831bda0975c81" id="s25594646">
						<DIV class="c_p_l_c_i_a" style="height: 20px;">
							<label for="b25594646"> <IMG alt="5-121204194026"
								src="http://i4.bvimg.com/609510/432575788e390fa3t.jpg"
								onload="if(($(this).parents('.c_p_l_c_i_a').height()<500)&&($(this).height()!=$(this).parents('.c_p_l_c_i_a').height())){$(this).parents('.c_p_l_c_i_a').height($(this).height())};" />
							</label>
						</DIV>
						<DIV class="c_p_l_c_i_b">
							<input type="checkbox" class="check_box" id="b25594646"
								data-id="25594646" /> <input type="text" value="5-121204194026"
								class="name_input" /> <input type="button" class="button"
								onclick="editpicname('25594646',$(this).prev().val(),'5-121204194026')"
								value="修改" title="修改图片名" />
						</DIV>
						<DIV class="c_p_l_c_i_b" style="margin-bottom: 4px">
							<input type="button" class="button copybtn"
								data-url="http://i4.bvimg.com/609510/432575788e390fa3.gif"
								value="原图" title="复制原图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/432575788e390fa3s.gif"
								value="展示图" title="复制展示图" /> <input type="button"
								class="button copybtn"
								data-url="http://i4.bvimg.com/609510/432575788e390fa3t.jpg"
								value="缩略图" title="复制缩略图" /> <input type="button"
								class="button" onclick="delpic('25594646');return false"
								value="删除" title="删除" />
						</DIV>
						<DIV class="c_p_l_c_i_c"></DIV>
						<DIV class="c_p_l_c_i_d"></DIV>
						<DIV class="c_p_l_c_i_e"></DIV>
					</DIV>
				</DIV>
			</DIV>
		</DIV>
		<div class="pages" style='clear: both'>
			<div></div>
		</div>
	</DIV>
	<div id="copyWindow" style="display: none">
		<span class="c_w_title"> 排序后复制 <span id="msg"
			style="display: none; color: #08B208"> 排序成功！请点击右侧按钮复制</span>
		</span> <span class="c_w_close" onclick="$('#copyWindow').hide()"></span>
		<div class="c_w_div">
			<ul class="gbin1-list"></ul>
		</div>
		<div class="c_w_right">
			<div class="c_w_title">复制代码:</div>
			<div class="c_w_t">HTML代码</div>
			<input type="button" data-id="turl" value="缩略图"
				class="cbtn sortCopyBtn_html"> <input type="button"
				data-id="surl" value="展示图" class="cbtn sortCopyBtn_html"> <input
				type="button" data-id="linkurl" value="原图"
				class="cbtn sortCopyBtn_html">
			<div class="c_w_t">UBB代码</div>
			<input type="button" data-id="turl" value="缩略图"
				class="cbtn sortCopyBtn_ubb"> <input type="button"
				data-id="surl" value="展示图" class="cbtn sortCopyBtn_ubb"> <input
				type="button" data-id="linkurl" value="原图"
				class="cbtn sortCopyBtn_ubb">
		</div>
	</div>
	<div class="pages" style="clear: both">
		<div></div>
	</div>
	<#include "foot.ftl">
</body>
<SCRIPT language="javascript"
	src="${basePath}/static/js/exhibition_2.js" type="text/javascript"></SCRIPT>
<SCRIPT language="javascript"
	src="${basePath}/static/js/jquery.zclip.min.js" type="text/javascript"></SCRIPT>
<SCRIPT language="javascript" src="${basePath}/static/js/useralbum.js"
	type="text/javascript"></SCRIPT>
<script language="javascript" src="${basePath}/static/js/recycle.js"
	type="text/javascript"></script>
<script>
	
</script>
</html>
</#compress>