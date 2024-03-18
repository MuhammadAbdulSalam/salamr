package play

import actionExecutor.ActionExecutor
import actionExecutor.SwipeAction
import core.DirManager
import core.Duration
import core.fakes.recordedInputJsonFile
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlayTest {

    private val actionExecutor: ActionExecutor = mockk()
    private val dirManager: DirManager = mockk()
    private val play = Play(dirManager, actionExecutor)

    @BeforeEach
    fun setup() {
        every { dirManager.getRecordedJsonFileText() }.returns(recordedInputJsonFile)
        every { dirManager.getRecordedInputFileText(any()) }.returns(recordedInputJsonFile)
        every { actionExecutor.swipe(any(), any()) }.answers {}
        every { actionExecutor.tap(any(), any(), any()) }.answers { }
    }

    @Test
    fun `when play, and valid input and no file name`() {
        play.run(null)
        verify(exactly = 1) { actionExecutor.swipe(SwipeAction.Custom(599, 1951, 599, 1315, 145), null) }
        verify(exactly = 1) { actionExecutor.tap(10, 1400, Duration(1.0)) }
    }

    @Test
    fun `when play, and valid input and multiple file name`() {
        play.run("first,second")
        verify(exactly = 2) { actionExecutor.swipe(SwipeAction.Custom(599, 1951, 599, 1315, 145), null) }
        verify(exactly = 2) { actionExecutor.tap(10, 1400, Duration(1.0)) }
    }
}

