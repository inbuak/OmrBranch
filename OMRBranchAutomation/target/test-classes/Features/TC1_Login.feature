@Login
Feature: Verifying Adactin Hotel login Details

  Scenario Outline: Verifying AdactinHotel Login valid credentials
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"

    Examples: 
      | userName    | passWord |
      | Inbanesan99 | elamaran |

  Scenario Outline: Verifying AdactinHotel Login using Enter key
    Given User is on the adactin hotel page
    When User should perform login using enter "<userName>" , "<passWord>"
    Then User should verify after login success message "Hello Inbanesan99!"

    Examples: 
      | userName    | passWord |
      | Inbanesan99 | elamaran |

  Scenario Outline: Verifying AdactinHotel Login invalid credentials
    Given User is on the adactin hotel page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login error message "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName  | passWord   |
      | Inbanesan | Hello@1234 |
