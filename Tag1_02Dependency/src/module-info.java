import de.dep.Depenccy;
import de.dep.impl.DependencyImpl;
import de.dep.impl.DependencyImpl2;

module Tag1_02Dependency {
	
	requires Tag1_03WeiteresJar;
	
	
	
	exports de.dep;
	
	uses Depenccy;
	provides Depenccy with DependencyImpl, DependencyImpl2;
}