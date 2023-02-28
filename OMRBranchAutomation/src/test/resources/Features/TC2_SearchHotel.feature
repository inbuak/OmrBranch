@SearchHotel
Feature: Verifying AdactinHotel Search Page details

  Scenario Outline: Verifying AdactinHotel Search with All inputs
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should Perform Search Hotel "<location>","<hotelName>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | userName    | passWord | location | hotelName   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | Inbanesan99 | elamaran | Sydney   | Hotel Creek | Standard | 1 - One   | 03/01/2023  | 04/01/2023   | 1 - One       | 1 - One       |

  Scenario Outline: Verifying AdactinHotel Search with only mandatory inputs
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should entry only mandatory fields "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | userName    | passWord | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Inbanesan99 | elamaran | Sydney   | 1 - One   | 03/01/2023  | 04/01/2023   | 1 - One       |

  Scenario Outline: Verifying AdactinHotel Search when CheckInDate greater than CheckOutDate
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should Perform Search Hotel "<location>","<hotelName>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after Search error messages "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName    | passWord | location | hotelName   | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | Inbanesan99 | elamaran | Sydney   | Hotel Creek | Standard | 1 - One   | 03/01/2024  | 04/01/2023   | 1 - One       | 1 - One       |

  Scenario Outline: Verifying AdactinHotel Search without enter any fields
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"
    And User should click on Search button
    Then User should verify after Search error message "Please Select a Location"

    Examples: 
      | userName    | passWord |
      | Inbanesan99 | elamaran |
