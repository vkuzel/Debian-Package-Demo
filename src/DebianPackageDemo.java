import java.io.IOException;
import com.sun.security.auth.module.UnixSystem;

public class DebianPackageDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Run application in a loop and schedule upgrade every half a minute.
		// Scheduling upgrade does not mean that application will upgrade. If
		// there is not new version and APT sources list has not been updated
		// then there will be nothing to upgrade.
		while (true) {
			Thread.sleep(30_000);
			upgrade();
		}
	}

	private static void upgrade() throws IOException {
		System.out.println("Schedule upgrade...");
		String scheduleUpgradeCommand = "systemd-run --user --on-active=1 /usr/lib/debian-package-demo/debian-package-demo-upgrade.sh";
		ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", scheduleUpgradeCommand);
		// Environment variable XDG_RUNTIME_DIR has to be set for
		// systemd-run to run correctly. Otherwise "Failed to create
		// bus connection" error will occur.
		processBuilder.environment().putIfAbsent("XDG_RUNTIME_DIR", "/run/user/" + new UnixSystem().getUid());
		// Redirect process I/O to the application's I/O so it's output can be
		// observed by journalctl.
		processBuilder.inheritIO();
		processBuilder.start();
	}
}

