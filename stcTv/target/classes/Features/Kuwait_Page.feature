@smoke

Feature: Validate type and price and currency For Kuwait "English_Version"

  Scenario: Validate to select the Kuwait country
    Given Navigate to HomePage stvTv
    Then Select Kuwait country
    And Validate for the plan types Lite,Classic,premium for Kuwait
    And Validate for the price and currency for Kuwait
