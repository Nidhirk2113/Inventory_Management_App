package com.example.inventorymanagementapp

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity

data class Item<T>(
    val name: String,
    val category: T,
    var stock: Int
)

class MainActivity : ComponentActivity() {

    private val inventory = mutableListOf(
        Item("Laptop","Electronics",5),
        Item("Mouse","Electronics",20),
        Item("Keyboard","Electronics",12),

        Item("Notebook","Stationery",25),
        Item("Pen","Stationery",50),
        Item("Marker","Stationery",15),

        Item("Chair","Furniture",3),
        Item("Desk","Furniture",6),

        Item("Water Bottle","Accessories",30),
        Item("Backpack","Accessories",8),

        Item("Monitor","Electronics",4),
        Item("Printer","Electronics",2)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.inputName)
        val categoryInput = findViewById<EditText>(R.id.inputCategory)
        val stockInput = findViewById<EditText>(R.id.inputStock)

        val result = findViewById<TextView>(R.id.resultText)

        val addBtn = findViewById<Button>(R.id.btnAdd)
        val lowStockBtn = findViewById<Button>(R.id.btnLowStock)
        val categoryBtn = findViewById<Button>(R.id.btnCategory)
        val totalsBtn = findViewById<Button>(R.id.btnTotals)
        val showAllBtn = findViewById<Button>(R.id.btnShowAll)

        // Add Item
        addBtn.setOnClickListener {

            val name = nameInput.text.toString()
            val category = categoryInput.text.toString()
            val stock = stockInput.text.toString().toIntOrNull()

            if(name.isNotEmpty() && category.isNotEmpty() && stock != null){

                inventory.add(Item(name,category,stock))

                result.text = "Item Added:\n$name ($category) - Stock: $stock"

                nameInput.text.clear()
                categoryInput.text.clear()
                stockInput.text.clear()

            } else {
                result.text = "Please enter valid details."
            }
        }

        // Show all items
        showAllBtn.setOnClickListener {

            result.text = inventory.joinToString("\n\n"){
                "${it.name}\nCategory: ${it.category}\nStock: ${it.stock}"
            }
        }

        // Low stock
        lowStockBtn.setOnClickListener {

            val lowStock = inventory.filter { it.stock < 10 }

            result.text = if(lowStock.isEmpty()){
                "No low stock items."
            } else {
                "Low Stock Items:\n\n" +
                        lowStock.joinToString("\n"){
                            "${it.name} (${it.category}) - ${it.stock}"
                        }
            }
        }

        // Filter electronics
        categoryBtn.setOnClickListener {

            val electronics = inventory.filter { it.category == "Electronics" }

            result.text = "Electronics Inventory:\n\n" +
                    electronics.joinToString("\n"){
                        "${it.name} - ${it.stock}"
                    }
        }

        // Category totals
        totalsBtn.setOnClickListener {

            val totals = inventory.groupBy { it.category }
                .mapValues { entry -> entry.value.sumOf { it.stock } }

            result.text = "Category Totals:\n\n" +
                    totals.entries.joinToString("\n"){
                        "${it.key} : ${it.value}"
                    }
        }
    }
}