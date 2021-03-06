<#compress> <!DOCTYPE html>
<html>
<TITLE>上传本地图片 - imagehosting</TITLE>
<HEAD>
<#include 'common.ftl'>
<link rel="stylesheet" href="${basePath}/static/js/upload/style.css">
<link rel="stylesheet" href="${basePath}/static/js/upload/webuploader.css">
<LINK rel="stylesheet" href="${basePath}/static/css/useralbum.css?v=160705" />
<style>
#sub_nav, #sub_nav2 {
	width: 122px;
}

#sub_nav ul, #sub_nav2 ul {
	margin: 0 20px;
}
</style>
<script>
	var allownum = '300';
	var successpid = '';
	//选中的album id
	var d_album = '${sessionScope.albumSelected}';
	$(function() {
		setTimeout(function() {
			$(window).resize();
		}, 500);
	})
</script>
</HEAD>
<BODY>
	<#include 'head.ftl'>
	<DIV class="container">
		<DIV class="upload" style="margin-top: 80px;">
			<DIV class="upload_t" style="font-size: 14px;">
				<span>
					<a href="${basePath}/upload/network">网络上传</a>
				</span>
				上传图片到我的图片库
			</DIV>
			<DIV class="upload_c">
				<@lib.selectAlbum />
				<DIV class="upload_c_b">
					<DIV id="uploadcontainer">
						<div id="uploader">
							<div class="queueList">
								<div id="dndArea" class="placeholder">
									<div id="filePicker"></div>
									<p>
										支持鼠标拖拽、QQ截屏后Ctrl+V粘贴、点击选择，单次最多可选
										<b style="color: #999">300</b>
										张
									</p>
								</div>
							</div>
							<div class="statusBar" style="display: none;">
								<div class="progress">
									<span class="text">0%</span>
									<span class="percentage"></span>
								</div>
								<div class="info"></div>
								<div class="btns">
									<div id="filePicker2"></div>
									<div class="uploadBtn">开始上传</div>
								</div>
							</div>
						</div>
					</DIV>
				</DIV>
				<DIV class="upload_c_c">温馨提示：图片格式支持JPG、JPEG、GIF、PNG；一次可添加上传300张图片，单张图片不可超过10M。</DIV>
			</DIV>
		</DIV>
		<#include 'foot.ftl'>
</BODY>
<script type="text/javascript" src="${basePath}/static/js/jquery.cookie.js"></script>
<SCRIPT type="text/javascript" src="${basePath}/static/js/useralbum.js"></SCRIPT>
<script type="text/javascript" src="${basePath}/static/js/upload/webuploader.js"></script>
<script type="text/javascript" src="${basePath}/static/js/upload/upload.js"></script>
<SCRIPT type="text/javascript" src="${basePath}/static/js/userupload.js"></SCRIPT>
</HTML>
</#compress>