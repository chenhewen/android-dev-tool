import java.io.IOException;

public class AppManager {

    private final AdbShell adbShell;

    public AppManager() {
        adbShell = new AdbShell();
    }

    public String getTopPkgName() {
        try {
            Process process = adbShell.dumpsys_window();
            String result = ProcessUtil.getResult(process);
            return AppRegex.parsePkgName(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 包含包名的完整类名
     * @return
     */
    public String getTopActivityName() {
        try {
            Process process = adbShell.dumpsys_window();
            String result = ProcessUtil.getResult(process);
            String className = AppRegex.parseClassName(result);
            if (className.startsWith(".")) {
                className = AppRegex.parsePkgName(result) + className;
            }
            return className;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String[] getTopComponentName() {
        try {
            Process process = adbShell.dumpsys_window();
            String result = ProcessUtil.getResult(process);
            String pkgName = AppRegex.parsePkgName(result);
            String className = AppRegex.parseClassName(result);
            return new String[]{pkgName, className};
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String[]{"", ""};
    }

    public String getApkPath(String pkgName) {
        Process process = adbShell.pm_path(pkgName);
        try {
            String result = ProcessUtil.getResult(process);
            return AppRegex.parseApkPath(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getTopApkPath() {
        String pkgName = getTopPkgName();
        return getApkPath(pkgName);
    }

    public void pullApk(String pkgName, String destPath) {
        String apkPath = getApkPath(pkgName);
        adbShell.pull_apk(apkPath, destPath);
    }

    public void pullTopApk(String destPath) {
        String pkgName = getTopPkgName();
        pullApk(pkgName, destPath);
    }
}
