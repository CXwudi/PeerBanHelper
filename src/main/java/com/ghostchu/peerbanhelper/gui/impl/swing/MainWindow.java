package com.ghostchu.peerbanhelper.gui.impl.swing;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.SystemInfo;
import com.ghostchu.peerbanhelper.ExternalSwitch;
import com.ghostchu.peerbanhelper.Main;
import com.ghostchu.peerbanhelper.downloader.DownloaderLastStatus;
import com.ghostchu.peerbanhelper.event.PBHServerStartedEvent;
import com.ghostchu.peerbanhelper.text.Lang;
import com.ghostchu.peerbanhelper.util.jcef.JCEFAppFactory;
import com.ghostchu.peerbanhelper.util.logger.LogEntry;
import com.google.common.eventbus.Subscribe;
import lombok.Cleanup;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.EnumProgress;
import me.friwi.jcefmaven.UnsupportedPlatformException;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefMessageRouter;
import org.cef.handler.CefKeyboardHandlerAdapter;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.logging.Level;

import static com.ghostchu.peerbanhelper.text.TextManager.tlUI;

@Slf4j
public final class MainWindow extends JFrame {
    @Getter
    private final SwingGuiImpl swingGUI;
    @Getter
    private final LogsTab logsTab;
    @Getter
    private final WindowMenuBar windowTitleBar;
    @Getter
    private final TrayMenu trayMenu;
    @Getter
    private final WebUITab webuiTab;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel tabbedPaneLogs;
    @Getter
    private JList<LogEntry> loggerTextList;
    @Getter
    private JScrollPane loggerScrollPane;


    public MainWindow(SwingGuiImpl swingGUI) {
        this.swingGUI = swingGUI;
        if (SystemInfo.isMacFullWindowContentSupported)
            getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
        setTitle(tlUI(Lang.GUI_TITLE_LOADING, Main.getMeta().getVersion(), Main.getMeta().getAbbrev()));
        // max dimension size or 720p
        var maxAllowedWidth = Math.min(1280, Toolkit.getDefaultToolkit().getScreenSize().width);
        var maxAllowedHeight = Math.min(720, Toolkit.getDefaultToolkit().getScreenSize().height);
        setSize(maxAllowedWidth, maxAllowedHeight);
        setContentPane(mainPanel);
        this.windowTitleBar = new WindowMenuBar(this);
        setupTabbedPane();
        this.trayMenu = new TrayMenu(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                trayMenu.minimizeToTray();
            }
        });
        ImageIcon imageIcon = new ImageIcon(Main.class.getResource("/assets/icon.png"));
        setIconImage(imageIcon.getImage());
        setVisible(!swingGUI.isSilentStart());
        this.logsTab = new LogsTab(this);
        this.webuiTab = new WebUITab(this);
    }


    public static void setTabTitle(JPanel tab, String title) {
        JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, tab);
        for (int tabIndex = 0; tabIndex < tabbedPane.getTabCount(); tabIndex++) {
            if (SwingUtilities.isDescendingFrom(tab, tabbedPane.getComponentAt(tabIndex))) {
                tabbedPane.setTitleAt(tabIndex, title);
                break;
            }
        }
    }

    public static void copyText(String content) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (Main.getServer() != null && Main.getServer().getWebContainer() != null) {
            Transferable ts = new StringSelection(content);
            clipboard.setContents(ts, null);
        }
    }


    public void sync() {
    }

    private void openWebUI() {
        if (Main.getServer() != null && Main.getServer().getWebContainer() != null) {
            swingGUI.openWebpage(URI.create("http://127.0.0.1:" + Main.getServer().getWebContainer().javalin().port() + "?token=" + Main.getServer().getWebContainer().getToken()));
        }
    }

    private void setupTabbedPane() {
        setTabTitle(tabbedPaneLogs, tlUI(Lang.GUI_TABBED_LOGS));
    }

    @Override
    public void dispose() {
        Main.getEventBus().unregister(this);
        this.webuiTab.close();
        super.dispose();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /** Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        tabbedPane = new JTabbedPane();
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        tabbedPaneLogs = new JPanel();
        tabbedPaneLogs.setLayout(new BorderLayout(0, 0));
        tabbedPane.addTab("Logs", tabbedPaneLogs);
        loggerScrollPane = new JScrollPane();
        loggerScrollPane.setEnabled(true);
        Font loggerScrollPaneFont = this.$$$getFont$$$(null, -1, -1, loggerScrollPane.getFont());
        if (loggerScrollPaneFont != null) loggerScrollPane.setFont(loggerScrollPaneFont);
        loggerScrollPane.setVerticalScrollBarPolicy(22);
        tabbedPaneLogs.add(loggerScrollPane, BorderLayout.CENTER);
        loggerTextList = new JList();
        Font loggerTextListFont = UIManager.getFont("TextArea.font");
        if (loggerTextListFont != null) loggerTextList.setFont(loggerTextListFont);
        loggerScrollPane.setViewportView(loggerTextList);
    }

    /** @noinspection ALL */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /** @noinspection ALL */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    /** @noinspection ALL */
    protected Font getFont(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1') && testFont.canDisplay('中')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static class WebUITab implements AutoCloseable {
        private final MainWindow parent;
        private CefApp app;
        private CefClient client;
        private CefBrowser browser;
        private Component awtComponent;
        private JCEFSwingDevTools devToolsDialog_ = null;

        public WebUITab(MainWindow parent) {
            this.parent = parent;
            Main.getEventBus().register(this);
        }

        @Subscribe
        public void onPeerBanHelperStarted(PBHServerStartedEvent event) {
            Thread.startVirtualThread(this::initJCEFEngine);
        }

        private void initJCEFEngine() {
            if (ExternalSwitch.parseBoolean("pbh.nojcef", false)
                    || Arrays.asList(Main.getStartupArgs()).contains("nojcef")
                    || !new File("enable-jcef.txt").exists()) { // File 是可执行文件同目录下的，这是预期行为 (install4j)
                return;
            }

            try {
                var jcefBuilder = JCEFAppFactory.createBuilder(Main.getDataDirectory(), Main.DEF_LOCALE);
                @Cleanup
                var progressDialog = Main.getGuiManager().createProgressDialog(
                        tlUI(Lang.JCEF_DOWNLOAD_TITLE),
                        tlUI(Lang.JCEF_DOWNLOAD_DESCRIPTION),
                        tlUI(Lang.GUI_COMMON_CANCEL),
                        null, false);
                jcefBuilder.setProgressHandler((enumProgress, v) -> {
                    if (enumProgress == EnumProgress.DOWNLOADING) {
                        progressDialog.show();
                        progressDialog.setProgressDisplayIndeterminate(false);
                        progressDialog.updateProgress(v / 100.0f);
                    }
                    if (enumProgress == EnumProgress.EXTRACTING) {
                        progressDialog.setDescription(tlUI(Lang.JCEF_DOWNLOAD_UNZIP_DESCRIPTION));
                        progressDialog.show();
                        progressDialog.updateProgress(v);
                        progressDialog.setProgressDisplayIndeterminate(true);
                    }
                });
                this.app = jcefBuilder.build();
                this.parent.tabbedPane.addTab(tlUI(Lang.GUI_TABBED_WEBUI), null);
                this.parent.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowActivated(WindowEvent e) {
                        checkIfBrowserShouldActive();
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        checkIfBrowserShouldActive();
                    }
                });
                checkIfBrowserShouldActive();
            } catch (IOException e) {
                log.error("Unable to load WebUI component", e);
            } catch (UnsupportedPlatformException e) {
                log.warn(tlUI(Lang.JCEF_BROWSER_UNSUPPORTED_PLATFORM));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (CefInitializationException e) {
                log.warn(tlUI(Lang.JCEF_BROWSER_UNSUPPORTED_EXCEPTION));
            }
        }

        private void checkIfBrowserShouldActive() {
            // debug output the event id mapping to the event name
            SwingUtilities.invokeLater(() -> {
                if (parent.isDisplayable() && parent.isVisible()) {
                    activeBrowser(this.parent.tabbedPane.indexOfTab(tlUI(Lang.GUI_TABBED_WEBUI)));
                } else {
                    deActiveBrowser(this.parent.tabbedPane.indexOfTab(tlUI(Lang.GUI_TABBED_WEBUI)));
                }
            });
        }

        private void activeBrowser(int tabPos) {
            if (this.browser == null) {
                this.client = app.createClient();
                CefMessageRouter msgRouter = CefMessageRouter.create();
                client.addMessageRouter(msgRouter);
                if (ExternalSwitch.parseBoolean("jcef.dev-tools", Main.getMeta().isSnapshotOrBeta() || "LiveDebug".equalsIgnoreCase(ExternalSwitch.parse("pbh.release")))) {
                    client.addKeyboardHandler(new CefKeyboardHandlerAdapter() {
                        @Override
                        public boolean onKeyEvent(CefBrowser browser, CefKeyEvent event) {
                            if (event.type == CefKeyEvent.EventType.KEYEVENT_KEYUP) {
                                switch (event.windows_key_code) {
                                    // F12 开发者工具
                                    case 123:
                                        devToolsShow(browser);
                                        break;
                                    default:
                                        return false;
                                }
                            }
                            return true;
                        }
                    });
                }
                this.browser = client.createBrowser(URI.create("http://127.0.0.1:" + Main.getServer().getWebContainer().javalin().port() + "?token=" + Main.getServer().getWebContainer().getToken()).toString(), false, false);
                this.awtComponent = this.browser.getUIComponent();
                this.parent.tabbedPane.setComponentAt(tabPos, this.awtComponent);
            }
        }

        private void deActiveBrowser(int tabPos) {
            this.parent.tabbedPane.setComponentAt(tabPos, new JPanel());
            if (this.browser != null) {
                this.browser.close(true);
                this.browser = null;
                if (this.client != null) {
                    this.client.dispose();
                    this.client = null;
                }
            }
        }

        /**
         * 开发者工具显示或隐藏
         * @param cefBrowser 显示开发者工具的浏览器
         */
        private void devToolsShow(CefBrowser cefBrowser) {
            if (cefBrowser.getURL().startsWith("devtools://")) {
                Thread.startVirtualThread(() -> parent.getSwingGUI().createDialog(Level.WARNING, "Cannot open devtools for a devtools page", "You cannot open PeerBanHelper devtools for a PeerBanHelper devtools page. (WHY YOU DO THAT? ARE YOU CRAZY?)"));
                return;
            }
            if (devToolsDialog_ != null) {
                devToolsDialog_.dispose();
            }
            // 因为是开发者工具，不能影响内容页面的显示，所以单独新建一个窗体显示
            var title = "PeerBanHelper WebUI DevTools (" + app.getVersion().toString() + ")";
            devToolsDialog_ = new JCEFSwingDevTools(new JFrame(), title, cefBrowser);
//            devToolsDialog_ = new DevToolsDialog(owner_, "开发者工具", cefBrowser);
            var maxAllowedWidth = Math.min(1280, Toolkit.getDefaultToolkit().getScreenSize().width);
            var maxAllowedHeight = Math.min(720, Toolkit.getDefaultToolkit().getScreenSize().height);
            devToolsDialog_.setSize(maxAllowedWidth, maxAllowedHeight);
            devToolsDialog_.setVisible(true);
        }

        @Override
        public void close() {
            deActiveBrowser(this.parent.tabbedPane.indexOfTab(tlUI(Lang.GUI_TABBED_WEBUI)));
            this.app.dispose();
            CefApp.getInstance().dispose();
        }
    }

    public static class TrayMenu {
        private final MainWindow parent;
        private boolean persistFlagTrayMessageSent;
        @Nullable
        @Getter
        private SwingTray swingTrayDialog;

        public TrayMenu(MainWindow parent) {
            this.parent = parent;
            setupSystemTray();
        }

        private void setupSystemTray() {
            if (SystemTray.isSupported()) {
                TrayIcon icon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/assets/icon.png")));
                icon.setImageAutoSize(true);
                SystemTray sysTray = SystemTray.getSystemTray();//获取系统托盘
                try {
                    var tray = new SwingTray(icon, mouseEvent -> parent.setVisible(true), mouseEvent -> updateTrayMenus());
                    sysTray.add(icon);//将托盘图表添加到系统托盘
                    updateTrayMenus();
                    this.swingTrayDialog = tray;
                } catch (AWTException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private void minimizeToTray() {
            if (swingTrayDialog != null) {
                parent.setVisible(false);
                if (!persistFlagTrayMessageSent) {
                    persistFlagTrayMessageSent = true;
                    parent.swingGUI.createNotification(Level.INFO, tlUI(Lang.GUI_TRAY_MESSAGE_CAPTION), tlUI(Lang.GUI_TRAY_MESSAGE_DESCRIPTION));
                }
            }
        }


        private void updateTrayMenus() {
            if (swingTrayDialog == null) return;
            List<JMenuItem> items = new ArrayList<>();
            JMenuItem openMainWindow = new JMenuItem(tlUI(Lang.GUI_MENU_SHOW_WINDOW), new FlatSVGIcon(Main.class.getResource("/assets/icon/tray/open.svg")));
            JMenuItem openWebUI = new JMenuItem(tlUI(Lang.GUI_MENU_WEBUI_OPEN), new FlatSVGIcon(Main.class.getResource("/assets/icon/tray/browser.svg")));
            JMenuItem quit = new JMenuItem(tlUI(Lang.GUI_MENU_QUIT), new FlatSVGIcon(Main.class.getResource("/assets/icon/tray/close.svg")));
            openMainWindow.addActionListener(e -> parent.setVisible(true));
            openWebUI.addActionListener(e -> parent.openWebUI());
            quit.addActionListener(e -> System.exit(0));
            items.add(menuDisplayItem(new JMenuItem(tlUI(Lang.GUI_MENU_STATS))));
            items.add(menuBanStats());
            items.add(menuDownloaderStats());
            items.add(menuDisplayItem(new JMenuItem(tlUI(Lang.GUI_MENU_QUICK_OPERATIONS))));
            items.add(openMainWindow);
            items.add(openWebUI);
            items.add(null);
            items.add(quit);
            swingTrayDialog.set(items);
        }

        private JMenuItem menuDownloaderStats() {
            var totalDownloaders = 0L;
            var healthDownloaders = 0L;
            if (Main.getServer() != null) {
                totalDownloaders = Main.getServer().getDownloaders().size();
                healthDownloaders = Main.getServer().getDownloaders().stream().filter(m -> m.getLastStatus() == DownloaderLastStatus.HEALTHY).count();
            }
            return new JMenuItem(tlUI(Lang.GUI_MENU_STATS_DOWNLOADER, healthDownloaders, totalDownloaders), new FlatSVGIcon(Main.class.getResource("/assets/icon/tray/connection.svg")));
        }

        private JMenuItem menuBanStats() {
            var bannedPeers = 0L;
            var bannedIps = 0L;
            var server = Main.getServer();
            if (server != null) {
                bannedIps = Main.getServer().getBannedPeers().values().stream().map(m -> m.getPeer().getAddress().getIp()).distinct().count();
                bannedPeers = Main.getServer().getBannedPeers().values().size();
            }
            return new JMenuItem(tlUI(Lang.GUI_MENU_STATS_BANNED, bannedPeers, bannedIps), new FlatSVGIcon(Main.class.getResource("/assets/icon/tray/banned.svg")));
        }

        private JMenuItem menuDisplayItem(JMenuItem jMenuItem) {
            jMenuItem.setEnabled(false);
            return jMenuItem;
        }

    }

    public static class WindowMenuBar {
        private final MainWindow parent;

        public WindowMenuBar(MainWindow parent) {
            this.parent = parent;
            parent.setJMenuBar(setupMenuBar());
        }


        private JMenuBar setupMenuBar() {
            JMenuBar menuBar = new JMenuBar();
            menuBar.add(generateProgramMenu());
            menuBar.add(generateWebUIMenu());
            if (!ExternalSwitch.parseBoolean("pbh.app-v")) {
                if (ExternalSwitch.parseBoolean("pbh.gui.debug-tools", Main.getMeta().isSnapshotOrBeta() || "LiveDebug".equalsIgnoreCase(ExternalSwitch.parse("pbh.release")))) {
                    menuBar.add(generateDebugMenu());
                }
            }
            //menuBar.add(Box.createGlue());
            menuBar.add(generateHelpAbout());
            parent.add(menuBar, BorderLayout.NORTH);
            return menuBar;
        }

        private Component generateHelpAbout() {
            JMenu menu = new JMenu(tlUI(Lang.GUI_MENU_ABOUT));
            JMenuItem creditMenu = new JMenuItem(tlUI(Lang.ABOUT_VIEW_CREDIT));
            creditMenu.addActionListener(e -> {
                var replaces = new HashMap<String, String>();
                replaces.put("{version}", Main.getMeta().getVersion());
                replaces.put("{username}", System.getProperty("user.name"));
                replaces.put("{worldEndingCounter}", "365");
                // 获取400年后的现在时刻, 格式化为 YYYY-MM-DD HH:mm:ss
                var future = Calendar.getInstance();
                future.add(Calendar.YEAR, 400);
                replaces.put("{lastLogin}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(future.getTime()));
                var window = new AboutWindow(replaces);
            });
            JMenuItem viewOnGithub = new JMenuItem(tlUI(Lang.ABOUT_VIEW_GITHUB));
            viewOnGithub.addActionListener(e -> parent.swingGUI.openWebpage(URI.create(tlUI(Lang.GITHUB_PAGE))));
            menu.add(viewOnGithub);
            menu.add(creditMenu);
            return menu;
        }

        private Component generateDebugMenu() {
            JMenu menu = new JMenu("-DEBUG-");
            JMenuItem disableJCEF = new JMenuItem("禁用 JCEF", new FlatSVGIcon(Main.class.getResource("/assets/icon/common/uac_shield.svg")));
            JMenuItem enableJCEF = new JMenuItem("启用 JCEF", new FlatSVGIcon(Main.class.getResource("/assets/icon/common/uac_shield.svg")));
            JMenuItem disableCheckUpdates = new JMenuItem("禁用检查更新", new FlatSVGIcon(Main.class.getResource("/assets/icon/common/uac_shield.svg")));
            JMenuItem enableCheckUpdates = new JMenuItem("启用检查更新", new FlatSVGIcon(Main.class.getResource("/assets/icon/common/uac_shield.svg")));
            var jcefFlagFile = new File("enable-jcef.txt");
            var disableCheckUpdatesFile = new File("disable-checking-updates.txt");
            enableJCEF.addActionListener(e -> {
                try {
                    if (jcefFlagFile.exists()) {
                        Main.getGuiManager().createDialog(Level.INFO, "启用 JCEF", "JCEF 已处于启用状态，无需再次启用.");
                    } else {
                        jcefFlagFile.createNewFile();
                        Main.getGuiManager().createDialog(Level.INFO, "启用 JCEF", "JCEF 已启用，请重启 PeerBanHelper 以使其生效.");
                    }
                } catch (IOException ex) {
                    Main.getGuiManager().createDialog(Level.SEVERE, "启用 JCEF", "无法启用 JCEF （写入启用 JCEF 标志失败），遇到了 IO 错误，请以管理员身份运行 PeerBanHelper 然后再试一次。");
                    log.error("启用 JCEF 失败", ex);
                }
            });
            disableJCEF.addActionListener(e -> {
                try {
                    if (jcefFlagFile.exists()) {
                        jcefFlagFile.delete();
                        Main.getGuiManager().createDialog(Level.INFO, "禁用 JCEF", "JCEF 已禁用，可关闭 PeerBanHelper 后删除 `jcef` 以释放磁盘空间.");
                    } else {
                        Main.getGuiManager().createDialog(Level.INFO, "禁用 JCEF", "JCEF 已处于禁用状态，无需再次禁用。");
                    }
                } catch (Exception ex) {
                    Main.getGuiManager().createDialog(Level.SEVERE, "禁用 JCEF", "无法禁用 JCEF（删除启用 JCEF 标志失败），遇到了 IO 错误，请以管理员身份运行 PeerBanHelper 然后再试一次。");
                    log.error("无法禁用 JCEF", ex);
                }
            });
            enableCheckUpdates.addActionListener(e -> {
                if (!disableCheckUpdatesFile.exists()) {
                    Main.getGuiManager().createDialog(Level.INFO, "启用检查更新（测试版）", "更新检查已处于启用状态，无需再次启用");
                    return;
                }
                if (disableCheckUpdatesFile.delete()) {
                    Main.getGuiManager().createDialog(Level.INFO, "启用检查更新（测试版）", "更新检查已启用，请重启 PeerBanHelper 以使其生效.");
                } else {
                    Main.getGuiManager().createDialog(Level.SEVERE, "启用检查更新（测试版）", "无法启用更新检查（删除禁用检查更新标志失败），遇到了 IO 错误，请以管理员身份运行 PeerBanHelper 然后再试一次。");
                }
            });
            disableCheckUpdates.addActionListener(e -> {
                if (disableCheckUpdatesFile.exists()) {
                    Main.getGuiManager().createDialog(Level.INFO, "禁用检查更新（测试版）", "更新检查已处于禁用状态，无需再次禁用");
                    return;
                }
                try {
                    if (disableCheckUpdatesFile.createNewFile()) {
                        Main.getGuiManager().createDialog(Level.INFO, "禁用检查更新（测试版）", "更新检查已禁用，但已计划的更新仍会在下次启动时安装。");
                    } else {
                        Main.getGuiManager().createDialog(Level.SEVERE, "禁用检查更新（测试版）", "无法禁用更新检查（创建禁用检查更新标志失败），遇到了 IO 错误，请以管理员身份运行 PeerBanHelper 然后再试一次。");
                    }
                } catch (IOException ex) {
                    log.error("禁用检查更新失败", ex);
                    Main.getGuiManager().createDialog(Level.SEVERE, "禁用检查更新（测试版）", "无法禁用更新检查（创建禁用检查更新标志失败），遇到了 IO 错误，请以管理员身份运行 PeerBanHelper 然后再试一次。");
                }
            });
            menu.add(disableJCEF);
            menu.add(enableJCEF);
            menu.addSeparator();
            menu.add(disableCheckUpdates);
            menu.add(enableCheckUpdates);
            return menu;
        }

        private Component generateProgramMenu() {
            JMenu menu = new JMenu(tlUI(Lang.GUI_MENU_PROGRAM));
            JMenuItem openDataDirectory = new JMenuItem(tlUI(Lang.GUI_MENU_OPEN_DATA_DIRECTORY));
            openDataDirectory.addActionListener(e -> {
                try {
                    Desktop.getDesktop().open(Main.getDataDirectory());
                } catch (IOException ex) {
                    log.warn("Unable to open data directory {} in desktop env.", Main.getDataDirectory().getPath());
                }
            });
            if (!ExternalSwitch.parseBoolean("pbh.app-v")) {
                menu.add(openDataDirectory);
            }
            menu.addSeparator();
            JMenuItem quit = new JMenuItem(tlUI(Lang.GUI_MENU_QUIT));
            quit.addActionListener(e -> System.exit(0));
            menu.add(quit);
            return menu;
        }

        private JMenu generateWebUIMenu() {
            JMenu webUIMenu = new JMenu(tlUI(Lang.GUI_MENU_WEBUI));
            JMenuItem openWebUIMenuItem = new JMenuItem(tlUI(Lang.GUI_MENU_WEBUI_OPEN));
            openWebUIMenuItem.addActionListener(e -> {
                parent.openWebUI();
            });
            webUIMenu.add(openWebUIMenuItem);
            JMenuItem copyWebUIToken = new JMenuItem(tlUI(Lang.GUI_COPY_WEBUI_TOKEN));
            copyWebUIToken.addActionListener(e -> {
                if (Main.getServer() != null && Main.getServer().getWebContainer() != null) {
                    String content = Main.getServer().getWebContainer().getToken();
                    copyText(content);
                    parent.swingGUI.createDialog(Level.INFO, tlUI(Lang.GUI_COPY_TO_CLIPBOARD_TITLE), String.format(tlUI(Lang.GUI_COPY_TO_CLIPBOARD_DESCRIPTION, content)));
                }
            });
            webUIMenu.add(copyWebUIToken);
            return webUIMenu;
        }


    }

    public static class LogsTab {
        private final MainWindow parent;

        public LogsTab(MainWindow parent) {
            this.parent = parent;

            parent.loggerTextList.setModel(new DefaultListModel<>());
            parent.loggerTextList.setFont(parent.loggerTextList.getFont().deriveFont(14f));
            parent.loggerTextList.setCellRenderer(new LogEntryRenderer());
            parent.loggerTextList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            parent.loggerTextList.setLayoutOrientation(JList.VERTICAL);
            parent.loggerTextList.setFixedCellHeight(-1);
        }
    }

    public static class LogEntryRenderer extends JTextArea implements ListCellRenderer<LogEntry> {
        public LogEntryRenderer() {
            setLineWrap(true);       // 启用自动换行
            setWrapStyleWord(true);  // 换行时按单词
            setOpaque(true);         // 设置为不透明
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends LogEntry> list, LogEntry value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.content().trim()); // 设置单元格内容

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
                switch (value.level()) {
                    case ERROR -> {
                        setBackground(new Color(255, 204, 187));
                        setForeground(Color.BLACK);
                    }
                    case WARN -> {
                        setBackground(new Color(255, 238, 204));
                        setForeground(Color.BLACK);
                    }
                }
            }
            setFont(list.getFont());

            // 动态计算行高，无需设置固定行高
            setSize(list.getWidth(), (int) getPreferredSize().getHeight());  // 设置 JTextArea 的宽度来支持换行
            return this;
        }
    }


}