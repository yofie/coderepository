<?php

include_once 'ConnectionDAO.php';
include_once __BEEMO_BASE_URL__.'/src/models/ParkingLotProvider.php';

Class ParkingDAO extends ConnectionDAO{
	
	public function getParkingLotProviders(){
		$listOfProviders = array();
		$SQLGETLISTOFPARKINGLOTPROVIDERS = "SELECT providerid, providername, address, providerdescription, googleplaceid FROM parkinglotproviders;";
		
		try{
			$mysqli = new mysqli();
			$mysqli = $this->getConnection();
			$stmt = $mysqli->prepare($SQLGETLISTOFPARKINGLOTPROVIDERS);
			$stmt->bind_result($providerId, $providerName, $address, $providerDescription, $googlePlaceId);
			$stmt->execute();
			
			while($stmt->fetch()) {
				$parkingLotProvider = new ParkingLotProvider($providerId, $providerName, $address, $providerDescription, $googlePlaceId);
				array_push($listOfProviders, $parkingLotProvider);
			}
		
		} catch(Exception $e){
			throw Exception($e);
		}
		
		return $listOfProviders;
	} 
}