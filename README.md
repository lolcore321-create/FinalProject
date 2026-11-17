# FinalProject — Automated UI Testing of prom.ua

Final project for the QA automation course. The project contains automated UI
tests for the [prom.ua](https://prom.ua) marketplace, built with the Page Object
pattern. Test cases are managed in TestRail, and every test result is sent there
automatically through the TestRail API.

## What is tested

14 UI tests, grouped by feature (one test class per feature):

| Area | Test class | What is checked |
|---|---|---|
| Cart | `CartTest` | Adding a product to the cart; removing a product and the empty cart state |
| Compare | `CompareProductsTest` | Two products are added to the compare list; the compare list is empty after clearing |
| Donations | `DonationTest` | Donate button is disabled for a closed campaign; the campaigns page shows enough cards; the percent on a card matches collected amount and goal |
| Help request | `HelpRequestTest` | Help request form shows an error message when it is submitted with an invalid email |
| Installments | `InstallmentPaymentTest` | Monthly payment shown on the product page matches the amount at checkout |
| Price filter | `PriceFilterTest` | All found products are within the selected price range |
| Promotions | `PromotionsDiscountTest` | Products in a promotion have a discounted price |
| Ratings | `RatingComparisonTest` | The prom.ua app rating matches the rating on Google Play |
| Search | `SearchProductTitleTextTest` | The product title in search results matches the title on the product page |
| Seller search | `SellerSearchTest` | A seller can be found by two different products |

## Tech stack

| Purpose | Tool |
|---|---|
| Language | Java 17+ |
| Build tool | Maven |
| UI automation | Selenide (on top of Selenium WebDriver 4) |
| Test framework | TestNG |
| API requests | REST Assured |
| JSON | Jackson |
| Test management | TestRail |

## Project structure

```
FinalProject
├── src
│   ├── main/java
│   │   ├── Final_Project   # Page Objects (HomePage, CartPage, ProductPage, ...)
│   │   └── TestRail        # TestRail request model (TestRequestDTO)
│   └── test/java/FinalProject
│       ├── BaseTest.java   # opens prom.ua before each test, sends results to TestRail
│       └── *Test.java      # test classes
├── pom.xml
└── runner.xml              # TestNG suite
```

## Test management (TestRail)

Test cases are stored in TestRail. Each test sets its TestRail case ID in the
`testCaseId` field (cases 3–16). After every test, `BaseTest` sends the result
to the TestRail API (`add_result_for_case`) using REST Assured:

- `1` — Passed
- `5` — Failed

The TestRail connection settings (API URL, run ID and user credentials) are
configured in `BaseTest`. Real credentials must never be published in the
repository.

## Prerequisites

- JDK 17 or newer
- Maven 3.8 or newer
- Google Chrome
- Internet access (the tests run against the live prom.ua site)
- A TestRail account with access to the configured test run (needed only for
  publishing results)

## How to run

Clone the repository:

```bash
git clone https://github.com/lolcore321-create/FinalProject.git
cd FinalProject
```

Run all tests:

```bash
mvn clean test
```

Run tests using the TestNG suite file:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=runner.xml
```

Run a single test class:

```bash
mvn clean test -Dtest=CartTest
```

## Reports

- After a run, the standard TestNG/Surefire report is available in
  `target/surefire-reports`.
- Results of every test are also visible in the corresponding test run in
  TestRail.

## Notes

- prom.ua is a live website: its markup, promotions, prices and captcha
  behaviour can change, which may affect test results.
- Some tests depend on external data (for example, the Google Play rating or
  the state of donation campaigns).

## Author

lolcore321
