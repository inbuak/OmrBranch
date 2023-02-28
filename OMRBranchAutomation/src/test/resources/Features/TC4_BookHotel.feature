@BookHotel
Feature: Verifying AdactinHotel Booking page details

  Scenario Outline: Verifying AdaactinHotel Booking with all inputs
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

    Examples: 
      | userName    | passWord | location | hotelName   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom | firstName | lastName | address     |
      | Inbanesan99 | elamaran | Sydney   | Hotel Creek | Standard | 1 - One   | 03/01/2023  | 04/01/2023   | 1 - One       | 1 - One       | Ram       | A        | OMR,CHENNAI |

  Scenario Outline: Verifying AdactinHotel booking without entering any inputs
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should Perform Search Hotel "<location>","<hotelName>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should perform Select hotel by hotel name
    Then User should verify after select hotel success message "Book A Hotel"
    And User should click on Book now button
    Then User should verify after click on Book now error messages "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName    | passWord | location | hotelName   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | Inbanesan99 | elamaran | Sydney   | Hotel Creek | Standard | 1 - One   | 03/01/2023  | 04/01/2023   | 1 - One       | 1 - One       |
