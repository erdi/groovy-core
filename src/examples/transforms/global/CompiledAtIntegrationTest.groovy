/*
 * Copyright 2003-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import transforms.global.CompiledAtASTTransformation 
import org.codehaus.groovy.ast.*
import org.codehaus.groovy.transform.*
import org.codehaus.groovy.control.*
import org.codehaus.groovy.tools.ast.*

/**
* This shows how to use the TransformTestHelper to test
* a global transformation. It is a little hard to invoke 
* because the CompiledAtASTTransformation must be on the 
* classpath but the JAR containing the transform must not
* or the transform gets applied twice. 
*
* @author Hamlet D'Arcy
*/ 
def transform = new CompiledAtASTTransformation()
def phase = CompilePhase.CONVERSION
def helper = new TransformTestHelper(transform, phase)
def clazz = helper.parse(' class MyClass {} ' )
assert clazz.getCompiledTime() != null
println 'compiled at' + clazz.getCompiledTime()
