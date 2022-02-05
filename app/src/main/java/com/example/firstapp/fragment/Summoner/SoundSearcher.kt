package com.example.firstapp.fragment.summoner

class SoundSearcher {

    /** * 검색을 한다. 초성 검색 완벽 지원함. * @param value : 검색 대상 ex> 초성검색합니다 * @param search : 검색어 ex> ㅅ검ㅅ합ㄴ * @return 매칭 되는거 찾으면 true 못찾으면 false.  */
    companion object {
        fun matchString(value: String, search: String): Boolean {
            var t = 0
            val seof = value.length - search.length
            val slen = search.length
            if (seof < 0) return false //검색어가 더 길면 false를 리턴한다.
            for (i in 0..seof) {
                t = 0
                while (t < slen) {
                    if (isInitialSound(search[t]) == true && isHangul(value[i + t])) {
                        //만약 현재 char이 초성이고 value가 한글이면
                        if (getInitialSound(value[i + t]) == search[t]) //각각의 초성끼리 같은지 비교한다
                            t++ else break
                    } else { //char이 초성이 아니라면
                        if (value[i + t] == search[t]) //그냥 같은지 비교한다.
                            t++ else break
                    }
                }
                if (t == slen) return true //모두 일치한 결과를 찾으면 true를 리턴한다.
            }
            return false //일치하는 것을 찾지 못했으면 false를 리턴한다.
        }

        private val HANGUL_BEGIN_UNICODE = 44032 // 가
            .toChar()
        private val HANGUL_LAST_UNICODE = 55203 // 힣
            .toChar()
        private val HANGUL_BASE_UNIT = 588 //각자음 마다 가지는 글자수
            .toChar()

        //자음
        private val INITIAL_SOUND = charArrayOf(
            'ㄱ',
            'ㄲ',
            'ㄴ',
            'ㄷ',
            'ㄸ',
            'ㄹ',
            'ㅁ',
            'ㅂ',
            'ㅃ',
            'ㅅ',
            'ㅆ',
            'ㅇ',
            'ㅈ',
            'ㅉ',
            'ㅊ',
            'ㅋ',
            'ㅌ',
            'ㅍ',
            'ㅎ'
        )


        /** * 해당 문자가 INITIAL_SOUND인지 검사. * @param searchar * @return  */
        private fun isInitialSound(searchar: Char): Boolean {
            for (c in INITIAL_SOUND) {
                if (c == searchar) {
                    return true
                }
            }
            return false
        }

        /** * 해당 문자의 자음을 얻는다. * * @param c 검사할 문자 * @return  */
        private fun getInitialSound(c: Char): Char {
            val hanBegin = c - HANGUL_BEGIN_UNICODE
            val index = hanBegin / HANGUL_BASE_UNIT.toInt()
            return INITIAL_SOUND[index]
        }

        /** * 해당 문자가 한글인지 검사 * @param c 문자 하나 * @return  */
        private fun isHangul(c: Char): Boolean {
            return HANGUL_BEGIN_UNICODE <= c && c <= HANGUL_LAST_UNICODE
        }
    }
}

