<?php
include_once __BEEMO_BASE_URL__."/src/dao/ParkingDAO.php";

Class ParkingController{
	private $parkingDAO;
	
	public function getParkingLotProviders(){
		$output = "";
		$codesofarray = array();
		
		try{
			$parkingDAO = new ParkingDAO();			
			$listOfProviders = $parkingDAO->getParkingLotProviders();
		
			foreach($listOfProviders as $lop){
				array_push($codesofarray, array($lop->getProviderId(), $lop->getProviderName(), $lop->getProviderAddress(), $lop->getProviderDescription(), $lop->getGooglePlaceId()));
			}
			
			$output = array("data" => $codesofarray);

		}catch(Exception $e){
			throw Exception($e);
		}
		
		return json_encode($output);
	}
}