package com.aulia.idn.crudkotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.aulia.idn.crudkotlin.R
import com.aulia.idn.crudkotlin.activity.ProductActivity
import com.aulia.idn.crudkotlin.model.PersonItem
import java.lang.String

class ProductAdapter(
    context: Context,
    resource: Int,
    objects: List<PersonItem>
) :
    ArrayAdapter<PersonItem?>(context, resource, objects) {
    private val personItem: List<PersonItem> = objects
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = inflater.inflate(R.layout.list_item, parent, false)
        val txtNameProduct = v.findViewById<TextView>(R.id.txt_product_name)
        val txtIdProduct = v.findViewById<TextView>(R.id.txt_product_id)
        val txtPriceProduct = v.findViewById<TextView>(R.id.txt_product_price)
        val txtDescProduct = v.findViewById<TextView>(R.id.txt_product_desc)

        txtNameProduct.text = (String.valueOf(personItem[position].name))
        txtIdProduct.text = (String.valueOf(personItem[position].id))
        txtPriceProduct.text = (String.valueOf(personItem[position].price))
        txtDescProduct.text = (String.valueOf(personItem[position].desc))

        v.setOnClickListener {
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra("id", String.valueOf(personItem[position].id))
            intent.putExtra("name", personItem[position].name)
            intent.putExtra("price", personItem[position].price)
            intent.putExtra("desc", personItem[position].desc)
            context.startActivity(intent)
        }
        return v
    }
}