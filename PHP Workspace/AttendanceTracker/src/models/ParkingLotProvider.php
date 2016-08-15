<?php
Class ParkingLotProvider{
	
	private $providerId;
	private $providerName;
	private $providerAddress;
	private $providerDescription;
	private $googlePlaceId;
	
	public function __construct($providerId, $providerName, $providerAddress, $providerDescription, $googlePlaceId){
		$this->providerId = $providerId;
		$this->providerName = $providerName;
		$this->providerAddress = $providerAddress;
		$this->providerDescription = $providerDescription;
		$this->googlePlaceId = $googlePlaceId;
	}
	
	public function getProviderId(){
		return $this->providerId;
	}
	
	public function setProviderId($providerId){
		$this->providerId = $providerId;
	}
	
	public function getProviderName(){
		return $this->providerName;
	}
	
	public function setProviderName($providerName){
		$this->providerName = $providerName;
	}
	
	public function getProviderAddress(){
		return $this->providerAddress;
	}
	
	public function setProviderAddress($providerAddress){
		$this->providerAddress = $providerAddress;
	}	
	
	public function getProviderDescription(){
		return $this->providerDescription;
	}
	
	public function setProviderDescription($providerDescription){
		$this->providerDescription = $providerDescription;
	}
	
	public function getGooglePlaceId(){
		return $this->googlePlaceId;
	}
	
	public function setGooglePlaceId($googlePlaceId){
		$this->googlePlaceId = $googlePlaceId;
	}
	
}