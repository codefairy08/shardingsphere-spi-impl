/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.orchestration.reg.zookeeper.natived.client.cache;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PathResolveTest {
    
    @Test
    public void assertNext() {
        final String path = "/test/a/bb/ccc/ddd";
        PathResolve pathResolve = new PathResolve(path);
        pathResolve.next();
        assertThat(pathResolve.getCurrent(), is("test"));
        pathResolve.next();
        assertThat(pathResolve.getCurrent(), is("a"));
        pathResolve.next();
        assertThat(pathResolve.getCurrent(), is("bb"));
        pathResolve.next();
        assertThat(pathResolve.getCurrent(), is("ccc"));
        pathResolve.next();
        assertThat(pathResolve.getCurrent(), is("ddd"));
    }
    
    @Test
    public void assertTrickEnd() {
        final String path = "/test/";
        PathResolve pathResolve = new PathResolve(path);
        pathResolve.next();
        assertThat(pathResolve.isEnd(), is(true));
    }
    
    @Test
    public void assertEnd() {
        final String path = "/test/a/bb";
        PathResolve pathResolve = new PathResolve(path);
        pathResolve.next();
        pathResolve.next();
        pathResolve.next();
        assertThat(pathResolve.isEnd(), is(true));
    }
}
