function submitForm(){
		$.ajax({
			url:"/history",
			data:"disaster="+document.getElementById("disaster").value + "&startDate=" + document.getElementById("startDate").value
						+ "&endDate=" + document.getElementById("endDate").value,
			type:'get',
		  	success:function(json){
				$("#message").text(json);
				populateLocation();
		  	},
			error:function(error){
				$("#errorMessage").text(error.responseText);
			}
		});
}

function populateLocation(){
	var locationList = document.getElementById("message").innerHTML;
	if(undefined != locationList){
        locationList = jQuery.parseJSON(locationList);
		map.setCenter({lat:parseFloat(locationList[0].latitude), lng:parseFloat(locationList[0].longitude)});
        for (var i = 0; i < locationList.length; i++) {
			var marker = new H.map.Marker({lat:parseFloat(locationList[i].latitude), lng:parseFloat(locationList[i].longitude)});
			map.addObject(marker);
			
			ui.addBubble(new H.ui.InfoBubble({lat:parseFloat(locationList[i].latitude), lng:parseFloat(locationList[i].longitude)}, {
		      content: "<a target='_blank' href='https://" + locationList[i].articleLink + "'>"+ locationList[i].articleLink +"</a>\n" + locationList[i].keyPoints
		    }));

			map.addEventListener('tap', function(evt) {
			    // Log 'tap' and 'mouse' events:
			    console.log(evt.type, evt.currentPointer.type); 
			});
			
        }
	}
}