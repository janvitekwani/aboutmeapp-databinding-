package com.example.aboutmedatabinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutmedatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //this binding object is like a glue between a layout and its views and the data
    // at time of binding activitymainbinding class is created by compiler
    private lateinit var binding : ActivityMainBinding//  here declaration is based on  "ActivityMain (xml file name )-Binding" , this get instantiated in oncreate
      val myName : MyName = MyName("JanviTekwani")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)// databindingutil is the class in data binding
// binding is the object against all the views

        binding.myName = myName

        binding.donebutton.setOnClickListener {
         binding.myName?.nickname = "hello! this is ${binding.nicenameEdit.text}" // text can be used for both getter and setter

              //  binding
            binding.nicenameEdit.visibility = View.GONE
            binding.donebutton.visibility = View.GONE
            binding.invalidateAll()
            binding.nicknametext.visibility = View.VISIBLE

            //hide the keyboard (still need to learn)
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.nicenameEdit.windowToken, 0)

        }
    }





}












/*   what is the event handling ?(set onclicklistener)
  event is the when user interact with android by clicking or long press . android framework maintain the event queue as first in first out basis like queue
  . it is very important for collecting data
  .there are three steps for event handling
    1) event listeners  (like on clicklistener)
    2) event listeners registration  ( we registre the listener like setonclicklistener on a paricluar view )
    3) event handlers (like onclick method means flow comes over this method and we perform the action we want )

  . there are three ways to implement onclicklistener
     1)implementation
     2) by using onclick
     3) by making annoymus inner class onclicklistner

  their are multliple event which we need to handle like button click , long press of a key and their are different function for each of them


 */

/* ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
what is the inputmethodmanage ?
 this  a input method framework that allows applications to provide user alternative input methods
 such as on screen keyboards , speech inputs

 let's understand the input subsystem architecture in android
   1)  driver( whenever we type something then electronic signals is generated ) ( KERNEL PART)
       |
   2)  eventhub(then all the event like (clicking, audio) is send to event hub ) TAKE RAW FROM KERNEL  (FRAMEWORK PART)
          |
   3)   input reader(that takes and process the event)   (FRAMEWORK )
        |
   4)  so in this way events are handled and managed , by using window manager service and phone window manager   (FRAMEWORK)
        |
   5)     application (USER SPACE)

 */


/* ............  KEYLAYOUT FILE.....................
all the key has the linux code attach to it has keyLayout file attached to it
 which has linux code for each key so whenever  a key is pressed the linux code is pressed

 if u want to customize your own keyboard u can make your own kcm files

 */

/*  .............................................................................................................................................................................
                                    KOTLIN FUNCTIONS
  1) fun  nameoffunction () - is the syntax  to declare the function
  2) nameoffunction () - this is the way to call the function
  3) fun calc (a:Int , b:Int , c:Int) - parameters function declaration
  4) fun calc (num :Int) :Unit - kotlin return type if kotlin function is not returning we donot need to specify any return type , but if we want we can add Unit as return type
        Unit = Void in java
  5) higher order function - fun Highorder(num1 : Int : Int, fname:(Int , Int ) ->Int)  // in this we can pass function as parameters in other function
  6) lambda functions - 1)fun main() { High(250 ,170 , {num1: Int , num2: Int -> num1+num2 })
                        2)fun high(num1 : Int , num2 : Int , calc : (Int , Int) -> Int)
                              {
                                  print(calc(num1, num2))
                               }

*/

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                  DATA BINDING
       It is a support LIBRARY part of jetpackcompose, that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than
        programmatically
      without data binding(programmatically)
           1)we have a text view first we will find text view
           2) then we set text and other property we have to set by using getter and setter method
           3) so in this everytime changes is done u have to set it again and again
        // means in this we have to write the code to do it like this and how

      with data binding ( declarativly)
            1) in this we have bind or textview with email dress so whenever updated in emaill textview changes
            2) so this binding which we have done of view with source we call it as data binding

      benefits of databinding library
        .findviewbyid  (find view by id is an expensive operation as it will find a from heirchacy and then work on it  )
        .nullpointerexception (in data binding ,binding is done in compile time )
        .performance and no memory leaks
        .nullpointerexception can be occured as we can set view in findviewbyid can be null , but in viewbinding this exception
           can't occur as view cannot be null


       view binding and data binding
           . view binding only binds view, with data binding u can also bind the data which belongs to this views
           . but problem with the data binding is that it takes larger build time , but with view binding their will be less build
             time
           . if u enable databinding , viewbinding will automatically enabled as viewbinding is the subset of the databinding as a
              whole

         ______________
        |              |         _______
        |              |        |        |
        |              | _bind_ |  data  |
        |              |        |        |
        |    view      |         --------
        |              |
         --------------

       rest check on activity main.xml (this tells the real power of data binding comes when we bind data)

 */