jQuery.fn.rotate=function(a,b){var c=this.get(0);if(!b){c.angle=((c.angle==undefined?0:c.angle)+ a)%360}else{c.angle=a}
var d;if(c.angle>=0){d=Math.PI*c.angle/180}else{d=Math.PI*(360+ c.angle)/ 180
var e=Math.round(Math.cos(d)*1000)/ 1000;
var h=c.width;var i=c.height;g.style.width=g.width=Math.abs(e*h)+ Math.abs(f*i);g.style.height=g.height=Math.abs(e*i)+ Math.abs(f*h);var j=g.getContext('2d');j.save();if(d<=Math.PI/2){j.translate(f*i,0)}else if(d<=Math.PI){j.translate(g.width,-e*i)}else if(d<=1.5*Math.PI){j.translate(- e*h,g.height)}else{j.translate(0,-f*h)}
j.rotate(d);j.drawImage(c,0,0,h,i);j.restore();c.style.display="none"}};jQuery.fn.rotateRight=function(a){this.rotate(a==undefined?90:a)};jQuery.fn.rotateLeft=function(a){this.rotate(a==undefined?-90:-a)};