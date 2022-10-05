@Testing
Feature: Tenant Login and Favorite

  Scenario Outline: tenant want to login and favorite unfavorite a kost
    Given tenant on jambu page
    When tenant click login tab
    And tenant fill in valid username
    And tenant fill in valid password
    Then tenant will direct to tenant homepage
    And tenant search <areaKost>
    And tenant will see area kost listing
    And tenant open tenth kost on the listing
    And tenant click favorite
    And tenant open favorite menu
    And tenant will see the kost favorited
    And tenant open the last favorited kost
    And tenant unfavorite the kost
    Then the kost unfavorited

    Examples:
      | areaKost |
      | tobelo   |



