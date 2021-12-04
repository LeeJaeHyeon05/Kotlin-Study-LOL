package com.example.firstapp.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.renderscript.Script
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.CustomAdapter
import com.example.firstapp.ItemsViewModel
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityMainBinding
import com.example.firstapp.databinding.FragmentItemBinding
import com.example.firstapp.databinding.FragmentSummonerSpellBinding

class SummonerSpellFragment : Fragment() {


    private var mBinding: FragmentSummonerSpellBinding? = null
    private val binding get() = mBinding!!


    lateinit var recyclerView1 : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSummonerSpellBinding.inflate(inflater, container, false)

        var rootView = inflater.inflate(R.layout.item_list,container,false)
        val data : ArrayList<ItemsViewModel> = ArrayList()

        data.add(ItemsViewModel(R.drawable.blue, "점멸"))

        recyclerView1 = rootView.findViewById(R.id.itemList!!) as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())

        return binding.root

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}


//class SummonerSpellFragment : Fragment() {
//
//
//    private var mBinding: FragmentSummonerSpellBinding? = null
//    private val binding get() = mBinding!!
//
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        mBinding = FragmentSummonerSpellBinding.inflate(inflater, container, false)
//
//        btnHandleOnclick()
//
//        return binding.root
//
//    }
//
//    override fun onDestroy() {
//        mBinding = null
//        super.onDestroy()
//    }
//
//    private fun btnHandleOnclick() {
//        binding.btnSmite.setOnClickListener (handleOnClick)
//        binding.btnTel.setOnClickListener (handleOnClick)
//        binding.btnShield.setOnClickListener (handleOnClick)
//        binding.btnFlash.setOnClickListener (handleOnClick)
//        binding.btnHeal.setOnClickListener (handleOnClick)
//        binding.btnFire.setOnClickListener (handleOnClick)
//        binding.btnClean.setOnClickListener (handleOnClick)
//        binding.btnExhausted.setOnClickListener (handleOnClick)
//        binding.btnTotheking.setOnClickListener (handleOnClick)
//        binding.btnThrowForo.setOnClickListener (handleOnClick)
//        binding.btnBlue.setOnClickListener (handleOnClick)
//        binding.btnGhost.setOnClickListener (handleOnClick)
//    }
//
//
//    private val messageMap: Map<Int, Array<Int>> = mapOf(
//        R.id.btn_smite to arrayOf(R.string.smiteDialogText, R.drawable.smite, R.string.smiteDialogTitle),
//        R.id.btn_tel to arrayOf(R.string.telDialogText, R.drawable.tel, R.string.telDialogTitle),
//        R.id.btn_flash to arrayOf(R.string.flashDialogText, R.drawable.flash, R.string.flashDialogTitle),
//        R.id.btn_Shield to arrayOf(R.string.sheildDialogText, R.drawable.sheild, R.string.sheildDialogTitle),
//        R.id.btn_clean to arrayOf(R.string.cleanDialogText, R.drawable.clean, R.string.cleanDialogTitle),
//        R.id.btn_heal to arrayOf(R.string.healDialogText, R.drawable.heal, R.string.healDialogTitle),
//        R.id.btn_fire to arrayOf(R.string.fireDialogText, R.drawable.fire, R.string.fireDialogTitle),
//        R.id.btn_exhausted to arrayOf(R.string.exhaustedDialogText, R.drawable.exhasuted, R.string.exhaustedDialogTitle),
//        R.id.btn_totheking to arrayOf(R.string.tothekingDialogText, R.drawable.totheking, R.string.tothekingDialogTitle),
//        R.id.btn_throwForo to arrayOf(R.string.throwforoDialogText, R.drawable.aiblue, R.string.throwforoDialogTitle),
//        R.id.btn_blue to arrayOf(R.string.blueDialogText, R.drawable.blue, R.string.blueDialogTitle),
//        R.id.btn_ghost to arrayOf(R.string.ghostDialogText, R.drawable.ghost, R.string.ghostDialogTitle),
//    )
//
//
//    private val handleOnClick: View.OnClickListener = View.OnClickListener {
//        val data = messageMap[it.id]
//        data?.run {
//            val dialogBuilder = AlertDialog.Builder(requireContext(), R.style.MyDialogTheme)
//
//            dialogBuilder.setMessage(getString(data[0]))
//                .setIcon(data[1])
//                .setCancelable(false)
//                .setNegativeButton(getString(R.string.nextDialogText)) { dialog, _ -> dialog.cancel() }
//
//            val alert = dialogBuilder.create()
//            alert.setTitle(getString(data[2]))
//            alert.show()
//
//        }
//    }
//}

/*
package com.example.firstapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smite : ImageButton = findViewById(R.id.btn_smite)
        val tel : ImageButton = findViewById(R.id.btn_tel)
        val shield : ImageButton = findViewById(R.id.btn_Shield)
        val flash : ImageButton = findViewById(R.id.btn_flash)
        val heal : ImageButton = findViewById(R.id.btn_heal)
        val fire : ImageButton = findViewById(R.id.btn_fire)
        val clean : ImageButton = findViewById(R.id.btn_clean)
        val ghost : ImageButton = findViewById(R.id.btn_ghost)
        val exhausted : ImageButton = findViewById(R.id.btn_exhausted)
        val totheking : ImageButton = findViewById(R.id.btn_totheking)
        val throwforo : ImageButton = findViewById(R.id.btn_throwForo)
        val blue : ImageButton = findViewById(R.id.btn_blue)



        smite.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("대상 에픽 및 대형/중형 몬스터, 혹은 적 미니언에게 450의 고정 피해를 입힙니다. 몬스터에게 사용 시 체력도 90 + 최대 체력의 10%만큼 회복됩니다.")
                .setIcon(R.drawable.smite)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                    dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        tel.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("4초 동안 정신 집중을 한 후 아군 구조물, 미니언, 혹은 와드로 순간이동하고 3초간 이동 속도가 50% 증가합니다.")
                .setIcon(R.drawable.tel)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        shield.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("2초 동안 방어막으로 감싸 피해를 115~455 만큼 흡수합니다.")
                .setIcon(R.drawable.sheild)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        flash.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("커서 방향으로 챔피언이 짧은 거리를 순간이동 합니다.")
                .setIcon(R.drawable.flash)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        heal.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("챔피언과 대상 아군 챔피언의 체력을 90~345만큼 회복시키고 1초 동안 이동 속도가 30% 증가합니다. 최근 소환사 주문 회복의 영향을 받은 유닛의 경우 치유량이 절반만 적용됩니다.")
                .setIcon(R.drawable.heal)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        fire.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("대상 적 챔피언을 불태워, 5초에 걸쳐 70~410의 고정 피해를 입히고 그동안 적의 위치를 드러내며 고통스러운 상처를 적용합니다.")
                .setIcon(R.drawable.fire)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        clean.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("챔피언의 최대 마나가 50%, 주변 아군의 최대 마나가 25%가 회복됩니다.")
                .setIcon(R.drawable.clean)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        exhausted.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("적 챔피언을 지치게 만들어 3초 동안 이동 속도를 30% 낮추며, 가하는 피해량을 40% 낮춥니다.")
                .setIcon(R.drawable.exhasuted)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        totheking.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("포로 왕의 곁으로 빠르게 이동합니다.")
                .setIcon(R.drawable.totheking)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        throwforo.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("2초 동안 방어막으로 감싸 피해를 115~455 만큼 흡수합니다.")
                .setIcon(R.drawable.aiblue)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        blue.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("챔피언의 최대 마나가 50%, 주변 아군의 최대 마나가 25%가 회복됩니다.")
                .setIcon(R.drawable.blue)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }

        ghost.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this, R.style.MyDialogTheme)

            dialogBuilder.setMessage("챔피언이 10초 동안 유닛과 충돌하지 않게 되며 챔피언 레벨에 따라 이동 속도가 24 ~ 48% 증가합니다.\n" +
                    "\n" +
                    "처치 관여 시 챔피언 레벨에 따라 유체화 지속 시간이 4 ~ 7초 늘어납니다.")
                .setIcon(R.drawable.ghost)
                .setCancelable(false)
                .setNegativeButton("계속 하기", DialogInterface.OnClickListener{
                        dialog, _ -> dialog.cancel()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("강타")
            alert.show()
        }
    }
}



<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/brightGray"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/lolText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dp"
        android:text="@string/lol"
        android:textColor="@color/white"
        android:textSize="38sp"
        app:layout_constraintBottom_toTopOf="@+id/btn_smite"
        tools:ignore="MissingConstraints" />

    <!--강타-->
    <ImageButton
        android:id="@+id/btn_smite"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="15dp"
        android:layout_marginTop="75dp"
        android:src="@drawable/smite"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/smite"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_smite"
        app:layout_constraintRight_toRightOf="@+id/btn_smite"
        app:layout_constraintTop_toBottomOf="@+id/btn_smite" />

    <!--텔-->
    <ImageButton
        android:id="@+id/btn_tel"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/tel"
        app:layout_constraintLeft_toRightOf="@id/btn_smite"
        app:layout_constraintTop_toTopOf="@id/btn_smite" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/tel"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_tel"
        app:layout_constraintRight_toRightOf="@+id/btn_tel"
        app:layout_constraintTop_toBottomOf="@+id/btn_tel" />
    <!--보호막-->
    <ImageButton
        android:id="@+id/btn_Shield"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/sheild"
        app:layout_constraintLeft_toRightOf="@id/btn_tel"
        app:layout_constraintTop_toTopOf="@id/btn_tel" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/sheild"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_Shield"
        app:layout_constraintRight_toRightOf="@+id/btn_Shield"
        app:layout_constraintTop_toBottomOf="@+id/btn_Shield" />

    <!--투더킹-->
    <ImageButton
        android:id="@+id/btn_totheking"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/totheking"
        app:layout_constraintTop_toBottomOf="@+id/HowlingText"
        app:layout_constraintLeft_toLeftOf="@+id/HowlingText"
        />

    <TextView
        android:id="@+id/textView5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/totheking"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_totheking"
        app:layout_constraintRight_toRightOf="@+id/btn_totheking"
        app:layout_constraintTop_toBottomOf="@+id/btn_totheking" />


    <!--유체화-->
    <ImageButton
        android:id="@+id/btn_ghost"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/ghost"
        app:layout_constraintLeft_toRightOf="@id/btn_clean"
        app:layout_constraintTop_toTopOf="@id/btn_clean" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/ghost"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_ghost"
        app:layout_constraintRight_toRightOf="@+id/btn_ghost"
        app:layout_constraintTop_toBottomOf="@+id/btn_ghost" />


    <!--         두번째 줄 두번째 줄 두번째 줄 두번째 줄                    -->

    <!-- 점화 -->
    <ImageButton
        android:id="@+id/btn_fire"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="15dp"
        android:layout_marginTop="35dp"
        android:src="@drawable/fire"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/btn_smite"
        app:layout_goneMarginTop="15dp" />

    <TextView
        android:id="@+id/textView7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/ignite"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_fire"
        app:layout_constraintRight_toRightOf="@+id/btn_fire"
        app:layout_constraintTop_toBottomOf="@+id/btn_fire" />

    <!--정화-->
    <ImageButton
        android:id="@+id/btn_clean"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/clean"
        app:layout_constraintLeft_toRightOf="@id/btn_fire"
        app:layout_constraintTop_toTopOf="@id/btn_fire" />

    <TextView
        android:id="@+id/textView8"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/clean"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_clean"
        app:layout_constraintRight_toRightOf="@+id/btn_clean"
        app:layout_constraintTop_toBottomOf="@+id/btn_clean" />
    <!--총명-->
    <ImageButton
        android:id="@+id/btn_blue"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/blue"
        app:layout_constraintLeft_toRightOf="@+id/btn_throwForo"
        app:layout_constraintTop_toBottomOf="@id/HowlingText"

        />

    <TextView
        android:id="@+id/textView9"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/blue"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_blue"
        app:layout_constraintRight_toRightOf="@+id/btn_blue"
        app:layout_constraintTop_toBottomOf="@+id/btn_blue" />

    <!--탈진-->
    <ImageButton
        android:id="@+id/btn_exhausted"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/exhasuted"
        app:layout_constraintLeft_toRightOf="@id/btn_ghost"
        app:layout_constraintTop_toTopOf="@id/btn_ghost" />

    <TextView
        android:id="@+id/textView10"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/exhasuted"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_exhausted"
        app:layout_constraintRight_toRightOf="@+id/btn_exhausted"
        app:layout_constraintTop_toBottomOf="@+id/btn_exhausted" />
    <!--포로 던지기-->
    <ImageButton
        android:id="@+id/btn_throwForo"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:src="@drawable/aiblue"
        app:layout_constraintLeft_toRightOf="@id/btn_totheking"
        app:layout_constraintTop_toTopOf="@id/btn_totheking" />

    <TextView
        android:id="@+id/textView11"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/aiblue"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_throwForo"
        app:layout_constraintRight_toRightOf="@+id/btn_throwForo"
        app:layout_constraintTop_toBottomOf="@+id/btn_throwForo" />
    <!--         세번째 줄 세번째 줄 세번째 줄 세번째 줄                    -->

    <!-- 점멸 -->
    <ImageButton
        android:id="@+id/btn_flash"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="40dp"
        android:layout_marginRight="20dp"
        android:src="@drawable/flash"
        app:layout_constraintLeft_toRightOf="@+id/btn_Shield"
        app:layout_constraintBottom_toBottomOf="@+id/btn_Shield"
        app:layout_constraintTop_toBottomOf="@id/lolText"
        android:layout_marginBottom="35dp" />

    <TextView
        android:id="@+id/textView12"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/flash"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_flash"
        app:layout_constraintRight_toRightOf="@+id/btn_flash"
        app:layout_constraintTop_toBottomOf="@+id/btn_flash" />
    <!-- 회복 -->
    <ImageButton
        android:id="@+id/btn_heal"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginTop="5dp"
        android:src="@drawable/heal"
        app:layout_constraintLeft_toRightOf="@+id/btn_flash"
        app:layout_constraintTop_toBottomOf="@+id/lolText"
        app:layout_constraintRight_toRightOf="parent
"
        />

    <TextView
        android:id="@+id/textView13"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/heal"
        android:textColor="@color/white"
        android:textSize="18sp"
        app:layout_constraintLeft_toLeftOf="@+id/btn_heal"
        app:layout_constraintRight_toRightOf="@+id/btn_heal"
        app:layout_constraintTop_toBottomOf="@+id/btn_heal" />

    <TextView
        android:id="@+id/HowlingText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/btn_fire"
        android:textSize="38sp"
        android:text="@string/HowlingAbyss"
        android:textColor="@color/white"
        android:layout_marginTop="40dp"
        tools:ignore="MissingConstraints" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/includelol"
        android:textSize="25sp"
        android:textColor="@color/white"
        app:layout_constraintLeft_toRightOf="@+id/HowlingText"
        app:layout_constraintBottom_toTopOf="@+id/btn_blue"
        android:layout_marginBottom="5dp"

        />



    <!-- 레드 표식 -->
    <!--    <ImageButton-->
    <!--        android:id="@+id/AiRed"-->
    <!--        android:layout_width="60dp"-->
    <!--        android:layout_height="60dp"-->
    <!--        app:layout_constraintLeft_toLeftOf="@+id/btn_exhausted"-->
    <!--        app:layout_constraintRight_toRightOf="@+id/btn_exhausted"-->
    <!--        app:layout_constraintTop_toBottomOf="@+id/btn_exhausted" />-->

    <!-- 블루 표식 -->
    <!--    <ImageButton-->
    <!--        android:id="@+id/btn_AiBlue"-->
    <!--        android:layout_width="60dp"-->
    <!--        android:layout_height="60dp"-->
    <!--        android:layout_marginLeft="20dp"-->
    <!--        android:layout_marginRight="20dp"-->
    <!--        app:layout_constraintTop_toBottomOf="@+id/btn_throwForo"-->
    <!--        app:layout_constraintLeft_toLeftOf="@+id/btn_throwForo"-->
    <!--        app:layout_constraintRight_toRightOf="@+id/btn_throwForo"-->
    <!--        />-->


</androidx.constraintlayout.widget.ConstraintLayout>
 */