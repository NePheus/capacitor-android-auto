// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorAndroidAuto",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "CapacitorAndroidAuto",
            targets: ["AndroidAutoPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "AndroidAutoPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/AndroidAutoPlugin"),
        .testTarget(
            name: "AndroidAutoPluginTests",
            dependencies: ["AndroidAutoPlugin"],
            path: "ios/Tests/AndroidAutoPluginTests")
    ]
)