Feature: book addition to basket

  Scenario: add book to basket

    Given an empty basket

    When i add a book to the basket

    Then the basket has one book


