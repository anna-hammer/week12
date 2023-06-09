import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.MethodSource;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.Argument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.*;



class TestDemoTest {
	
	private TestDemo testDemo = new TestDemo();
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
	if(!expectException) {
		assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	}
		
		else {
			assertThatThrownBy(() -> 
			testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
			
		}
		}
		
		public static Stream<Object> argumentsForAddPositive() {
			return Stream.of(
				arguments(5,4,9, false),
				arguments(1,-1,0, true),
				arguments(2,-1,1, true),
				arguments(15,5,20, false)
					);
			
		}

		private static Object arguments(int i, int j, int k, boolean b) {
			// TODO Auto-generated method stub
			return null;
		}



	@Test
	private void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	
	
	}
	}
