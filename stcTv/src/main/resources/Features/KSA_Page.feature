@smoke
Feature: Validate type and price and currency For KSA "English_Version"

  Scenario: Validate to select the KSA country
    Given Navigate to stvTv
    Then Select the country
    And Validate for the plan types Lite,Classic,premium for KSA
    And Validate for the price and currency for KSA





