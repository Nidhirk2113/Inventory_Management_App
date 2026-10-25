# Inventory Management App

A simple Android inventory management application built with Kotlin. It lets users maintain a list of items, review stock levels, identify low-stock products, and summarize inventory by category.

## Features

- **Add inventory items** with a name, category, and stock quantity.
- **View all items** currently in the inventory.
- **Identify low-stock items** with fewer than 10 units.
- **Filter Electronics items** to quickly view products in that category.
- **View category totals** by summing the stock quantities for each category.
- **Sample inventory** included to explore the app immediately.

## Tech Stack

- **Language:** Kotlin
- **Platform:** Android
- **UI:** Android XML layouts and Android widgets
- **Build system:** Gradle (Kotlin DSL)
- **Android components:** AndroidX Activity

## Getting Started

### Prerequisites

- Android Studio
- Android SDK compatible with the project configuration (compile SDK 36)
- JDK compatible with the Gradle version configured by the project
- An Android device or emulator running **Android 7.0 (API 25)** or later

### Run the project

1. Clone this repository:

   ```bash
   git clone https://github.com/Nidhirk2113/Inventory_Management_App.git
   ```

2. Open the `Inventory_Management_App` folder in Android Studio.
3. Allow Android Studio to sync the Gradle project and download required dependencies.
4. Start an Android emulator or connect an Android device with USB debugging enabled.
5. Click **Run** in Android Studio to build and install the app.

You can also build the debug APK from the project root:

**Windows (PowerShell):**

```powershell
.\gradlew.bat assembleDebug
```

**macOS / Linux:**

```bash
./gradlew assembleDebug
```

The generated APK is typically available at `app/build/outputs/apk/debug/app-debug.apk`.

## How to Use

1. Enter an item name, category, and stock quantity.
2. Select **Add Item** to add it to the current inventory list.
3. Use **Show All** to display all items and their stock quantities.
4. Use **Low Stock** to display items with fewer than 10 units.
5. Use **Category** to show items in the Electronics category.
6. Use **Totals** to see the sum of stock quantities for each category.

## Sample Inventory

The app starts with sample items across these categories:

| Category | Example items |
|---|---|
| Electronics | Laptop, Mouse, Keyboard, Monitor, Printer |
| Stationery | Notebook, Pen, Marker |
| Furniture | Chair, Desk |
| Accessories | Water Bottle, Backpack |

## Project Structure

```text
Inventory_Management_App/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/inventorymanagementapp/
│   │   │   ├── MainActivity.kt
│   │   │   └── ui/theme/
│   │   ├── res/
│   │   │   └── layout/activity_main.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
│   └── libs.versions.toml
├── build.gradle.kts
├── settings.gradle.kts
└── gradlew / gradlew.bat
```

## Notes and Limitations

- Inventory data is currently held in memory. Items added during a session are not saved permanently and may be lost when the app process is restarted.
- The low-stock threshold is currently fixed at **fewer than 10 units**.
- The category filter currently targets the exact category name `Electronics`.
- This is a starter project that can be extended with persistent storage, item editing and deletion, search, barcode scanning, and inventory history.

## Future Enhancements

- Persist inventory using Room or another local database.
- Add edit and delete actions for inventory items.
- Support search and filtering by any category.
- Add stock-in and stock-out transactions.
- Introduce input validation for non-negative stock quantities.
- Improve the UI with a searchable list and stock-status indicators.

## Author

**Nidhi Kulkarni**

GitHub: [@Nidhirk2113](https://github.com/Nidhirk2113)

---

If you find this project useful, consider starring the repository.
