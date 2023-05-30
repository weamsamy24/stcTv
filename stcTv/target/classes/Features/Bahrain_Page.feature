@smoke

Feature: Validate type and price and currency For Bahrain "English_Version"

  Scenario: Validate to select the Bahrain country
    Given Navigate to Bahrain stvTv
    Then Select Bahrain country
    And Validate for the plan types Lite,Classic,premium for Bahrain
    And Validate for the price and currency for Bahrain
