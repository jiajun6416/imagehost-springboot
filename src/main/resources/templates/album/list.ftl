<#compress>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人相册--${session_user_key.nickname}</title>
<#include 'common.ftl'>
<LINK href="static/css/useralbum.css?v=03141" rel="stylesheet" type="text/css" />
</head>
<body>
	<#include "head.ftl">
	<DIV class="container">
		<DIV class="user">
			<DIV class="user_nav">
				<SPAN class="user_nav_a" style="display:inline-block;">
					<span style="color: black;font-weight: 600;">${session_user_key.nickname}</span>的个人相册&nbsp;&nbsp;</SPAN>
				<span class="user_nav_b" id="create_a" >
					<input type="button" value="回收站" onclick="window.location.href='${basePath}/recycle'" class="cbtn upload_c_a_c_b_a_b">
					<input type="button" value="创建相册" onclick="createalbum()" class="cbtn upload_c_a_c_b_a_b">
				</span>
			</DIV>
			<DIV class="album" style="margin-top:100px;">
				<#list albumList as album>
					<SPAN class="album_i" data-type="0">
						<a href="${basePath}/list/${album.id}">
							<SPAN class="album_i_a">
								<#list album.imageList as image>
									<#switch image?counter>
										<#case 1>
									 		<img style="width:200px;height:200px;float: left;" src="${image.imageZoomUrl}" alt/>	
										<#break>
										<#case 2>
										 	<SPAN class="album_i_a_b album_i_a_bno album_i_a_bnob"><img src="${image.imageZoomUrl}" alt/></SPAN>
										<#break>
										<#case 3>
											<SPAN class="album_i_a_b album_i_a_bno album_i_a_bnob"><img src="${image.imageZoomUrl}" alt/></SPAN>									
										<#break>
										<#case 4>
											<SPAN class="album_i_a_b album_i_a_bno"><img src="${image.imageZoomUrl}" alt/></SPAN>
										<#break>
										<#case 5>
											<SPAN class="album_i_a_b album_i_a_bno album_i_a_bnob"><img src="${image.imageZoomUrl}" alt/></SPAN>
										<#break>
										<#case 6>
									</#switch>
								</#list>
							</SPAN>
							<SPAN class="album_i_b">${album.name}</SPAN></a>
							<SPAN class="album_i_c">
								<SPAN class="album_i_c_a">
									<num>${album.imageSize}</num>
									<a href="javascript:;" onclick="updatenum(this,${album.id})" title="更新图片数量">
										<img src="static/image/re.png" width="12" /></a>
								</SPAN>
								<#if album.isPublic>
										<SPAN class="album_i_c_c_unlock cog tip" onclick="setalbumlock('1','${album.id}')" title="公开可见">公开</SPAN>								
								<#else>
										<SPAN class="album_i_c_lock cog tip" onclick="setalbumlock('0','${album.id}')" title="私密相册内图片仅自己可见" style="color: green">私密</SPAN>	
								</#if>
								<SPAN class="album_i_c_b">
									<A class="album_i_c_b_a" onclick="delalbum('${album.id}',this);return false;" href="javascript:void(0);">删除</A>
									<A onclick="editalbum('${album.id}',this,${album.isPublic});return false;" href="javascript:void(0);">编辑</A>
							  </SPAN>
						</SPAN>
					</SPAN>
				</#list>
				<SPAN class="album_fixed"></SPAN>
			</DIV>
		</DIV>
		<div class="pages" style="clear:both">
			<div></div>
		</div>
		<#include "foot.ftl">
</body>
<SCRIPT language="javascript" src="static/js/useralbum.js?v=161028" type="text/javascript"></SCRIPT>
</html>
</#compress>