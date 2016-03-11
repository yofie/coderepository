/*!
 * @author: Jonathan Leijendekker
 * @author: Allan Queddeng
 */

var googlemap = {
	message : ''
};

$(function() {

//	$("#SearchForm [type=reset]").click(function(e) {
//		e.preventDefault();
//		$("#SearchForm").find($("[name]")).each(function() {
//			$(this).val("");
//		});
//	});
//	runDateTimePickers();	
});

function showLogin() {
	$("#Login_Modal").modal('show');
}

function runDateTimePickers(){
	var nowDate = new Date();
	var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
	
	$('.input-datepicker').datepicker({
		autoclose : true,
		container: ".input-datepicker",
		format : 'yyyy-mm-dd',
		orientation: 'auto left'
	});
	
	$('#AppointmentStart').timepicker({ 'scrollDefault': 'now' });
	$('#AppointmentEnd').timepicker({ 'scrollDefault': 'now' });
}

function validateLogin() {
	var params = $('#validateLogin').serializeArray();
	params.push({
		name : 'email',
		value : $("#email").val()
	});
	params.push({
		name : 'passwd',
		value : $("#passwd").val()
	});
	validateUser("post", params).done(function(data) {
		$("#Login_Table").html(data);
		var isvalid = $("#isvalid").val();
		if (isvalid == "true") {
			$("#Login_Modal").modal('hide');
			window.location = contextPath + "/Scheduler";
		}
	});
}

function logout() {
	logoutUser("post", '').done(function(data) {
		window.location = contextPath + "/";
	});
}

function setAppointment() {
	var params = $('#AppointmentForm').serializeArray();
	
	params.push({
		name : 'propertyid',
		value : $("#PropertyId").val()
	});
	params.push({
		name : 'customername',
		value : $("#CustomerName").val()
	});
	params.push({
		name : 'customeremailadd',
		value : $("#CustomerEmailAdd").val()
	});
	params.push({
		name : 'customercontactnumber',
		value : $("#CustomerContactNumber").val()
	});	
	params.push({
		name : 'appointmentdate',
		value : $("#AppointmentDate").val()
	});
	params.push({
		name : 'appointmentstart',
		value : $("#AppointmentStart").val()
	});
	params.push({
		name : 'appointmentend',
		value : $("#AppointmentEnd").val()
	});

	validateAppointment("post", params).done(function(data) {
		$("#Appointment_Table").html(data);
		runDateTimePickers();
		var isvalid = $("#isvalidappointment").val();
		if (isvalid == "true") {
			$("#AppointmentModal").modal('hide');
		}
	});
}

function validateUser(method, params) {
	return $.ajax({
		url : contextPath + "/ValidateLogin",
		method : method,
		data : params
	});
}

function logoutUser(method, params) {
	return $.ajax({
		url : contextPath + "/LogOut",
		method : method,
		data : params
	});
}

function validateAppointment(method, params) {
	return $.ajax({
		url : contextPath + "/SetAppointment",
		method : method,
		data : params
	});
}

/**
 * Google Map API variables and settings
 */
var geocoder;
var map;
var settings;

function initializeGoogleMap(title, address, element) {

	settings = {
		zoom : 10,
		mapTypeControl : true,
		mapTypeControlOptions : {
			style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
		},
		navigationControl : true,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById(element), settings);

	geocode(title, address);
}

function geocode(title, address) {
	geocoder = new google.maps.Geocoder();
	if (geocoder) {
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {

					google.maps.event.trigger(map, 'resize');

					map.setCenter(results[0].geometry.location);

					var infowindow = new google.maps.InfoWindow({
						content : '<b>' + address + '</b>',
						size : new google.maps.Size(150, 50)
					});

					var marker = new google.maps.Marker({
						position : results[0].geometry.location,
						map : map,
						title : title
					});
					google.maps.event.addListener(marker, 'click', function() {
						infowindow.open(map, marker);
					});
				} else {
					googlemap.message = "No results found";
					$(document).trigger('google.map.status');
				}
			} else {
				googlemap.message = "Address search was unsuccessful with the reason: " + status;
				$(document).trigger('google.map.status');
			}
		});
	}
}