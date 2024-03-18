package help

fun showHelp(header: String? = null, showElementSummary: Boolean = false) {
    val salamr = "salamr"
    header?.let {
        println()
        println(header)
        println()
    }
    println(
        """
             -l (Locate) - Locate and Tap single item - Usage: ~$$salamr -l Home"
             -m (Multi Locate)- Locate and Tap multiple item in a sequence - Usage: ~\$$salamr -m Account|Theme|Dark (avoid extra spaces)
             -r (Record)- Record inputs on emulator - Usage: ~\$$salamr -r         
                -f (file) can be used with -r in order to specify a recording name, Usage: ~\$$salamr -r -f yourFileNameHere
             -p (Play)- Play recorded inputs on emulator - Usage: ~\$$salamr -p
                optional argument to play specific test file, Usage: ~\$$salamr -p yourFileNameHere
             -d (Delete)- Delete recording file/files or use 'all' to delete all - Usage: ~\$$salamr -d 'fileOne,fileTwo'
        """.trimIndent()
    )
    if (showElementSummary) {
        println()
        println(
            """
             Element Summary: 
             *****SWIPE*****
             SU - Swipe Up
             SD - Swipe Down
             SL - Swipe Left
             SR - Swipe Right
             Swipe can be used with custom params such as SU for example
             SU(startX,startY,amount,durationInMillis) - Example Usage: ~$salamr -m Home|SU(100,100,200,350)
             
             *****Delay*****
             D - Delay 
             Custom delay to be added as Seconds - Example Usage: ~$salamr -m Home|D1.3|Info|D0.5
             
             *****BACK*****
             B - System Back Press
             
             *****Elements*****
             call elements to find by name, additional option index can be added such as [0] 
             Example Usage: ~$salamr -m Home|Info[2]|Videos[1]
             By default index [0] is selected
             
             ******TextFields*****
             TF[INDEX-HERE](TEXT-TO-SEND) use TF to send text to text fields
             £ample Usage: ~$salamr -m Home|TF[0](my text here)|TF[1](my text here)
             
             *****Sample*****
             Here's an example usage: 
             ~$salamr -m 'TF[0](some text)|Reviews|SU|SU|Relationship[1]|Relationship[1]|Info|SU|SU|see more|SU|see less|AutoTrader|D1|B|D1|B'
             
        """.trimIndent()
        )
    }
}