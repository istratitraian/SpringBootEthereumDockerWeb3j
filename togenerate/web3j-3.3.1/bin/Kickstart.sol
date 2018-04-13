pragma solidity ^0.4.17;
        contract CampaignFactory{

        address[] private deployedCampagns;
                function createCampaign(uint minimum) public{
                deployedCampagns.push(new Campaign(minimum, msg.sender));
                }

        function getDeployedCampaigns() public view returns(address[]){
        return deployedCampagns;
        }
        }


contract Campaign{

struct Request{
string description;
        uint value;
        address recipient; //vendor
        bool complete;
        uint approvalCount; // Votted yes
        mapping(address => bool) approvals;
        }

Request[] public requests;
        address public manager;
        uint public minimumContribution;
        // address[] public approvers;
        mapping(address => bool) public approvers;
        uint public approvalsCount;
        modifier onlyManager(){
require(msg.sender == manager);
        _;
        }

function Campaign(uint minimum, address creator) public payable{
// manager = msg.sender;
manager = creator;
        minimumContribution = minimum;
        }

function contribute() public payable{
require(msg.value > minimumContribution);
        approvers[msg.sender] = true;
        approvalsCount++;
        }


function createRequest(string description, uint value, address vendor) public onlyManager{


requests.push(Request({
description:description,
        value:value,
        recipient:vendor,
        complete:false,
        approvalCount:0
        }));
        }



function approveRequest(uint reqIndex) public{
require(approvers[msg.sender]);
        Request storage request = requests[reqIndex];
        require(!request.approvals[msg.sender]);
        request.approvalCount++;
        request.approvals[msg.sender] = true;
        }

function finalizeRequest(uint reqIndex) public onlyManager{
Request storage request = requests[reqIndex];
        require(!request.complete);
        require(request.approvalCount > approvalsCount / 2);
        request.recipient.transfer(request.value); //
        request.complete = true;
        }


        function getSummary() public view returns(uint, uint, uint, uint, address){
        return (
            minimumContribution,
            this.balance,
            requests.length,
            approvalsCount,
            manager
            );
        }

        function getRequestsCount() public view returns(uint){
        return requests.length;
        }

}
