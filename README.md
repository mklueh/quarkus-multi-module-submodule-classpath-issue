# Multi-Module Quarkus submodule not contained in classpath with :quarkusBuild

This example is not functional and is meant to reproduce Issue 

## Usage

This project contains two bash scripts to reproduce the failing case and a "workaround"
that will produce a working jar file

To build and run the application like you normally would do, run

> start-without-prebuild-common-failure.sh


To **pre-build** the **common** library and then build and run the actual application, run

> start-with-prebuild-common-success.sh


#### Issue

Exception that it will produce when started with

> ./gradlew :application:quarkusBuild

`java.lang.NoClassDefFoundError: com/demo/common/model/SharedModel
        at com.demo.application.Application.schedule(Application.java:19)
        at com.demo.application.Application_Subclass.schedule$$superaccessor8(Application_Subclass.zig:21)
        at com.demo.application.Application_Subclass$$function$$8.apply(Application_Subclass$$function$$8.zig:29)
        at io.quarkus.arc.impl.AroundInvokeInvocationContext.proceed(AroundInvokeInvocationContext.java:54)
        at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.invokeInOurTx(TransactionalInterceptorBase.java:119)
        at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.invokeInOurTx(TransactionalInterceptorBase.java:92)
        at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired.doIntercept(TransactionalInterceptorRequired.java:32)
        at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorBase.intercept(TransactionalInterceptorBase.java:53)
        at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired.intercept(TransactionalInterceptorRequired.java:26)
        at io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired_Bean.intercept(TransactionalInterceptorRequired_Bean.zig:168)
        at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:41)
        at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:41)
        at io.quarkus.arc.impl.InvocationContexts.performAroundInvoke(InvocationContexts.java:32)
        at com.demo.application.Application_Subclass.schedule(Application_Subclass.zig:86)
        at com.demo.application.Application_ClientProxy.schedule(Application_ClientProxy.zig:51)
        at com.demo.application.Application_ScheduledInvoker_schedule_dce0524c3f1de653f83719900424446459b7c471.invokeBean(Application_ScheduledInvoker_schedule_dce0524c3f1de653f83719900424446459b7c471.zig:45)
        at io.quarkus.arc.runtime.BeanInvoker.invoke(BeanInvoker.java:20)
        at io.quarkus.scheduler.runtime.SimpleScheduler$2.run(SimpleScheduler.java:123)
        at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
        at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:2011)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1535)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1426)
        at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:29)
        at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:29)
        at java.base/java.lang.Thread.run(Thread.java:834)
        at org.jboss.threads.JBossThread.run(JBossThread.java:479)
` 



