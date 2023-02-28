@SelectHotel
Feature: Verifying AdactinHotel Select page details

  Scenario Outline: Verifying AdactinHotel Select by hotel name
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should Perform Search Hotel "<location>","<hotelName>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should perform Select hotel by hotel name
    Then User should verify after select hotel success message "Book A Hotel"

    Examples: 
      | userName    | passWord | location | hotelName   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | Inbanesan99 | elamaran | Sydney   | Hotel Creek | Standard | 1 - One   | 03/01/2023  | 04/01/2023   | 1 - One       | 1 - One       |

  Scenario Outline: Verifying AdactinHotel Select without selecting hotel
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should Perform Search Hotel "<location>","<hotelName>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should click on continue
    Then User should verify after click on continue error message "Please Select a Hotel"

    Examples: 
      | userName    | passWord | location | hotelName   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | Inbanesan99 | elamaran | Sydney   | Hotel Creek | Standard | 1 - One   | 03/01/2023  | 04/01/2023   | 1 - One       | 1 - One       |
