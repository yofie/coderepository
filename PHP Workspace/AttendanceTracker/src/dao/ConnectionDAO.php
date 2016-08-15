<?php
class ConnectionDAO{

	private $server = "10.1.10.74";
	private $username = "gemshrdbuser";
	private $password = "gpdO99GEQU";
	private $schema = "hrdb";
	private $port = "3306";
	
	public function getConnection(){
		$conn = new mysqli($this->server, $this->username, $this->password, $this->schema, $this->port);
		return $conn; 		
	}
	
}