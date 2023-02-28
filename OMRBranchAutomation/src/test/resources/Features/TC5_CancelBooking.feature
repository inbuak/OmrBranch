@CancelBooking
Feature: Verifying AdactinHotel Cancel Booking page details

  Scenario Outline: Verifying AdactinHotel Cancel booking with generated orderId
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should Perform Search Hotel "<location>","<hotelName>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should perform Select hotel by hotel name
    Then User should verify after select hotel success message "Book A Hotel"
    And User should perform Hotel Booking "<firstName>","<lastName>" and "<address>"
      | ccNo             | ccType           | expMonth | expYear | cvvNum |
      | 1234567890123450 | American Express | December |    2022 |    132 |
      | 1234567890123451 | VISA             | December |    2022 |    234 |
      | 1234567890123452 | Master Card      | December |    2022 |    567 |
      | 1234567890123453 | Other            | December |    2022 |    567 |
    Then User should verify after hotel booking success meassage "Booking Confirmation" and save the orderId
    And User should Cancel the generated orderId
    Then User should verify after Cancel success message "The booking has been cancelled."

    Examples: 
      | userName    | passWord | location | hotelName   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom | firstName | lastName | address     |
      | Inbanesan99 | elamaran | Sydney   | Hotel Creek | Standard | 1 - One   | 03/01/2023  | 04/01/2023   | 1 - One       | 1 - One       | Ram       | A        | OMR,CHENNAI |

  Scenario Outline: Verifying AdactinHotel Cancel booking with existing orerId
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should perform Cancel the existing orederId "<orderId>"
    Then User should verify after Cancel success message "The booking has been cancelled."

    Examples: 
      | userName    | passWord | orderId    |
      | Inbanesan99 | elamaran | 88PJB1TNMR |
