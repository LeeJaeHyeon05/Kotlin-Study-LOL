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
